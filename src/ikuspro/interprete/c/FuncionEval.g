// autor: Ivan Mosquera Paulo 
// email: ivanmosp@gmail.com
// nombreInterprete: euiti-bi_LSI_FI_C
// version:	1.0
// extensiones:	c cpp
//

// ==================== FuncionEval.g : fichero de int�rprete AST, primera pasada =======================

// En este fichero lo que hacemos es hacer una primera interpretaci�n del �rbol AST generado desde 
// el analizador sint�ctico.

// En este fichero lo que hacemos es ver qu� hay en cada momento en la rama del �rbol AST en que estamos
// y generamos el c�digo Java del int�rprete correspondiente. 
// La parte izquierda de las reglas es id�ntica a la parte derecha de las reglas de los analizadores.
// Esto es as� porque en los analizadores en la parte derecha defin�amos qu� AST generabamos y ahora
// en la parte izquiera definimos qu� parte del AST estamos mirando. 

tree grammar FuncionEval;

options {
	tokenVocab = C; // Se utilizar�n los tokens definidos en la gram�tica C.g
	ASTLabelType = CommonTree;
}

// A�adimos lo que necesitemos.
@header {
	package ikuspro.interprete.c;
	import ikuspro.interprete.c.*;
	import ikuspro.interprete.c.ParametroFuncion;
	import java.util.List;
	import java.util.ArrayList;
}

// Solo se evaluan las funciones para poder declararlas.
programa 
	:	^(PROGRAMA ^(DECLARACIONES_GLOBALES .*) ^(FUNCIONES funciones) .) 
	|	^(PROGRAMA ^(FUNCIONES funciones) .)
	; 

funciones 
	:	
	funcion+
	;
	

// Una regla puede devolver estructuras de datos que pueden ser utilizadas como informaci�n por otras reglas.
// En este caso devolvemos un String con el tipo.
tipo_base returns [String valor]
	:	'void' { $valor = "void"; }
	|	'char' { $valor = "char"; }
	| 	'int' { $valor = "int"; }
	|	'float' { $valor = "float"; }
	|	'double' { $valor = "float"; } // Por simplicidad en este punto hacemos que un double sea en la pr�ctica un float. 
	|	'string' { $valor = "string"; }
	;

// Se declaran las funciones.
funcion
scope {
	List<ParametroFuncion> listaParametros; // Necesitamos una lista donde guardar los par�metros de la funci�n.
	String nombre;
	String tipo;
	int ini;
	int fin;
}

// En @init definimos el c�digo que se inserta antes de empezar la regla.
@init {
	$funcion::listaParametros = new ArrayList<ParametroFuncion>();
}

// En @after definimos el c�digo que se inserta tras haber terminado la regla.
// Como en este punto es cuando tenemos toda la informaci�n, es donde hacemos lo m�s interesante.
@after {
	// Guardamos en una variable el nodo que nos interesa del �rbol.
	CommonTree nodoBloque = (CommonTree) $funcion.start.getChild(1);
	//System.out.println("INDEX : " + String.valueOf(input.index())); 
	int i = $funcion::ini;
	boolean encontrado = false;
	
	// Sabemos el nodo que queremos pero no sabemos el �ndice.
	// Lo que s� sabemos son los �ndices entre los que acotar la b�squera, inicio y f�n
	// de la funci�n, y tambi�n sabemos lo que hay que buscar. 
	// Menos mal porque de lo contrario ser�a inviable por lo ineficiente.
	// En versiones anteriores de ANTLR hab�a m�todos que hac�an esto directamente pero ya no por
	// cuestiones de eficiencia. De hecho muchos ejemplos de int�rpretes que hay en la WEB para 
	// Antlr no son funcionales por esta raz�n.
	// Es posible que haya una forma m�s eficiente de hacer esto pero yo no la he encontrado.
	while(!encontrado && i <= $funcion::fin) {
		if (input.get(i) == nodoBloque) {
			encontrado = true;
		} else {
			i++;
		}
	}
	// Los System.out residuales no son recomendables pero en algunos casos los mantenemos comentados
	// porque son tremendamente �tiles de cara a debuggear el int�rprete.
	//System.out.println("TREE : " + nodoBloque.toStringTree());
	
	// Aqu� es donde finalmente declaramos la funci�n con la informaci�n que tenemos.
	Interprete.getTablaSimbolos().declararFuncion($funcion::nombre,$funcion::tipo, $funcion::listaParametros, nodoBloque, i);
	
}
	: ^(FUNCION { $funcion::ini = input.index();} ^(CABECERA_FUNCION cabecera_funcion  ) { $funcion::fin = input.index();}  .)  
	
	// Un par de detalles:
	// Tambi�n podemos insertar c�digo dentro de la regla, en esta regla por ejemplo necesitaremos el indice donde empieza
	// la funci�n y obviamente eso lo sabemos en el momento que estamos en ese �ndice.
	// Del mismo modo necesitaremos saber el indice de donde termina la funci�n.
	// El "." que vemos al final lo que hace es ignorar parte del �rbol, en este caso ignoramos el bloque de la funci�n
	// porque en esta primera pasada del �rbol AST no vamos a mirar ah�.
	
	;
	
cabecera_funcion returns [String nombre, String tipo] 
	:	
	declaracion_nombre_funcion lista_param_formales? 
	{ $funcion::nombre = $declaracion_nombre_funcion.nombre; $funcion::tipo = $declaracion_nombre_funcion.tipo; }
		
	;

declaracion_nombre_funcion returns [String nombre, String tipo]
	:	^(DECLARACION_NOMBRE_FUNCION ^(NOMBRE_FUNC IDENT)) { $nombre = $IDENT.text; $tipo = "void"; $funcion::tipo = $tipo;}
	|	^(DECLARACION_NOMBRE_FUNCION ^(TIPO_BASE tipo_base ) ^(NOMBRE_FUNC IDENT)) 
					{ $nombre = $IDENT.text; $tipo = $tipo_base.valor; $funcion::tipo = $tipo;}
	;
	
lista_param_formales 
	:	param_formal ( param_formal )*
	;

// En esta regla se a�aden los par�metros. Vemos que se utiliza la variable global de la regla funcion.
// Hay que entender el orden en que se van ejecutando estas reglas. 
// Por ejemplo cuando estamos en funcion, estar� formado por par�metros formales, y cuando estamos en esta 
// regla de par�metros formales en realidad todav�a estamos en el �mbito de la regla funcion, la regla funcion
// no ha terminado por lo que podemos darle informaci�n que luego utilizar� en su @after por ejemplo.	
param_formal
	:	
		^(PARAM_FORMAL ^(TIPO_BASE tipo_base) ^(NOMBRE_VAR IDENT) )
		{ $funcion::listaParametros.add(new ParametroFuncion($IDENT.text,$tipo_base.valor)); 
		}
	|	^(PARAM_FORMAL_ARR ^(TIPO_BASE tipo_base) ^(NOMBRE_VAR IDENT) )
		{ $funcion::listaParametros.add(new ParametroFuncion($IDENT.text,$tipo_base.valor,true)); 
		  //System.out.println("El parametro es un array");
		}
	
	;
