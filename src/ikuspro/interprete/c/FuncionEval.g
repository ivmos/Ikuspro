// autor: Ivan Mosquera Paulo 
// email: ivanmosp@gmail.com
// nombreInterprete: euiti-bi_LSI_FI_C
// version:	1.0
// extensiones:	c cpp
//

// ==================== FuncionEval.g : fichero de intérprete AST, primera pasada =======================

// En este fichero lo que hacemos es hacer una primera interpretación del árbol AST generado desde 
// el analizador sintáctico.

// En este fichero lo que hacemos es ver qué hay en cada momento en la rama del árbol AST en que estamos
// y generamos el código Java del intérprete correspondiente. 
// La parte izquierda de las reglas es idéntica a la parte derecha de las reglas de los analizadores.
// Esto es así porque en los analizadores en la parte derecha definíamos qué AST generabamos y ahora
// en la parte izquiera definimos qué parte del AST estamos mirando. 

tree grammar FuncionEval;

options {
	tokenVocab = C; // Se utilizarán los tokens definidos en la gramática C.g
	ASTLabelType = CommonTree;
}

// Añadimos lo que necesitemos.
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
	

// Una regla puede devolver estructuras de datos que pueden ser utilizadas como información por otras reglas.
// En este caso devolvemos un String con el tipo.
tipo_base returns [String valor]
	:	'void' { $valor = "void"; }
	|	'char' { $valor = "char"; }
	| 	'int' { $valor = "int"; }
	|	'float' { $valor = "float"; }
	|	'double' { $valor = "float"; } // Por simplicidad en este punto hacemos que un double sea en la práctica un float. 
	|	'string' { $valor = "string"; }
	;

// Se declaran las funciones.
funcion
scope {
	List<ParametroFuncion> listaParametros; // Necesitamos una lista donde guardar los parámetros de la función.
	String nombre;
	String tipo;
	int ini;
	int fin;
}

// En @init definimos el código que se inserta antes de empezar la regla.
@init {
	$funcion::listaParametros = new ArrayList<ParametroFuncion>();
}

// En @after definimos el código que se inserta tras haber terminado la regla.
// Como en este punto es cuando tenemos toda la información, es donde hacemos lo más interesante.
@after {
	// Guardamos en una variable el nodo que nos interesa del árbol.
	CommonTree nodoBloque = (CommonTree) $funcion.start.getChild(1);
	//System.out.println("INDEX : " + String.valueOf(input.index())); 
	int i = $funcion::ini;
	boolean encontrado = false;
	
	// Sabemos el nodo que queremos pero no sabemos el índice.
	// Lo que sí sabemos son los índices entre los que acotar la búsquera, inicio y fín
	// de la función, y también sabemos lo que hay que buscar. 
	// Menos mal porque de lo contrario sería inviable por lo ineficiente.
	// En versiones anteriores de ANTLR había métodos que hacían esto directamente pero ya no por
	// cuestiones de eficiencia. De hecho muchos ejemplos de intérpretes que hay en la WEB para 
	// Antlr no son funcionales por esta razón.
	// Es posible que haya una forma más eficiente de hacer esto pero yo no la he encontrado.
	while(!encontrado && i <= $funcion::fin) {
		if (input.get(i) == nodoBloque) {
			encontrado = true;
		} else {
			i++;
		}
	}
	// Los System.out residuales no son recomendables pero en algunos casos los mantenemos comentados
	// porque son tremendamente útiles de cara a debuggear el intérprete.
	//System.out.println("TREE : " + nodoBloque.toStringTree());
	
	// Aquí es donde finalmente declaramos la función con la información que tenemos.
	Interprete.getTablaSimbolos().declararFuncion($funcion::nombre,$funcion::tipo, $funcion::listaParametros, nodoBloque, i);
	
}
	: ^(FUNCION { $funcion::ini = input.index();} ^(CABECERA_FUNCION cabecera_funcion  ) { $funcion::fin = input.index();}  .)  
	
	// Un par de detalles:
	// También podemos insertar código dentro de la regla, en esta regla por ejemplo necesitaremos el indice donde empieza
	// la función y obviamente eso lo sabemos en el momento que estamos en ese índice.
	// Del mismo modo necesitaremos saber el indice de donde termina la función.
	// El "." que vemos al final lo que hace es ignorar parte del árbol, en este caso ignoramos el bloque de la función
	// porque en esta primera pasada del árbol AST no vamos a mirar ahí.
	
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

// En esta regla se añaden los parámetros. Vemos que se utiliza la variable global de la regla funcion.
// Hay que entender el orden en que se van ejecutando estas reglas. 
// Por ejemplo cuando estamos en funcion, estará formado por parámetros formales, y cuando estamos en esta 
// regla de parámetros formales en realidad todavía estamos en el ámbito de la regla funcion, la regla funcion
// no ha terminado por lo que podemos darle información que luego utilizará en su @after por ejemplo.	
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
