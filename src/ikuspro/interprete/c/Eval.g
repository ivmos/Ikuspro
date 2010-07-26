// autor: Ivan Mosquera Paulo 
// email: ivanmosp@gmail.com
// nombreInterprete: euiti-bi_LSI_FI_C
// version:	1.0
// extensiones:	c cpp
//

// ==================== Eval.g : fichero de intérprete AST,  segunda y última pasada =======================

// En FuncionEval lo que hemos hecho es una primera pasada para ver las funciones que hay y declararlas guardandolas.
// Ahora realizaremos una segunda pasada donde hacemos todo lo demás que es el 90% del interpretado.

tree grammar Eval;

options {
	tokenVocab = C;
	// Tipo de objeto en los nodos
	ASTLabelType=CommonTree; 
}

@header {
	package ikuspro.interprete.c;
	import ikuspro.interprete.c.*;
	import ikuspro.simulador.*;
	import java.util.HashMap;
	import java.io.*;
	import java.util.Properties;
	import java.util.Iterator;
	import ikuspro.gui.*;
	import javax.swing.JOptionPane;
	import java.lang.reflect.InvocationTargetException;
	
}

// Lo que hay en members es código que se pondrá como atributos y métodos adicionales de la clase Eval.
@members {
	
	BufferedTreeNodeStream flujo = (BufferedTreeNodeStream) input; // El input en realidad se entiende mejor como flujo.
									// Es el flujo de ejecución.
	
	Interprete interprete; // Necesitaremos referencia a la clase interprete para algunas cosas.
	
	String texto; // Por necesidad de tener referencias globales tenemos algunos atributos que ahora pueden no parecer
		      // tener sentido pero sí luego.
	
	private String entrada;
	
	// Un constructor personalizado para poder recibir la referencia al interprete
	public Eval(TreeNodeStream input, Interprete pInterprete) {
		this(input);
		interprete = pInterprete;
		texto = "";
	}
   	
   	// Mada al interprete que lea la entrada estándar para cierta variable de nombre pNombre
   	public String leerStdin(String pNombre) {
   		return interprete.leerStdin(pNombre);
   	}	
    	
    	// Lo que hacemos en Eval es ir formando Strings con el XML correspondiente a lo que se va
    	// interpretando. Es decir, un compilador suele generar código máquina y un intérprete suele 
    	// limitarse a ir interpretando las acciones.
    	// En nuestro caso nuestro intérprete hace más cosas que un intérprete al uso ya que se va explicando
    	// diciendo paso a paso con XML lo que va haciendo y la línea en que está. Esto servirá para que Ikuspro realice la 
    	// simulación gráfica.
    	
    	// Salida estándar
   	public void echo(String pString) {
   		interprete.enviar("<salida><texto>" + pString + "</texto></salida>");
   	}
   	
   	// Método genérico para mandar XML.
   	public void enviar(String pString) {
   		interprete.enviar(pString);
   	}
   	
   	// Notificar línea 
   	public void enviarLinea(int pNum) {
   		interprete.enviar("<linea><num>" + pNum + "</num></linea>");
   	}
   	
}

// Veremos que algunas reglas se repiten respecto a FuncionEval. Hay que entender que esta
// es una nueva pasada del árbol desde arriba, no partimos del punto en que termina FuncionEval
// ni nada parecido.

programa
@init {
	
}

@after {
	
}
	:	^(PROGRAMA { /***/ } ^(DECLARACIONES_GLOBALES declaraciones_globales) ^(FUNCIONES .*) llamada  )  
	|	^(PROGRAMA { /***/ } ^(FUNCIONES .*) llamada  )
	;
	
	
declaraciones_globales
@init {
	/////////
}

@after {
	/////////////
}
	:
	declaracion_global+
	;
	

	
// tipos basicos soportados
tipo_base returns [String valor]
@init {
	
}

@after {
	
}
	:	'void' { $valor = "void"; }
	|	'char' { $valor = "char"; }
	| 	'int' { $valor = "int"; }
	|	'float' { $valor = "float"; }
	|	'double' { $valor = "float"; /* Lo dicho en FuncionEval */ }
	|	'string' { $valor = "string"; }
	;
	

declaracion_global
@init {
	
}

@after {
	
}
	:	precompilacion  
	;




sentencia 

@init {
	// Puede que estemos dentro de una función. Si no lo estamos no hacemos nada pero sino hay que evaluar desde ese indice.
	try{
		if(! $llamada::ejecutable){
                	matchAny(flujo);
                	return;
        	}
        } catch(java.util.EmptyStackException ignore){
        	// Hay algunas excepciones que nos permitimos la licencia de ignorar
        	// En este caso esta excepción aparece cuando no estamos en una funcion por lo que 
        	// el atributo ::ejecutable no está accesible.
        	
        }


	
}
@after {
	///////////
	
}

	:	
	  bloque
	| ^(RETURN expr)	{$llamada::valorRetorno=$expr.valor; $llamada::ejecutable=false;}
	| sentencia_asignacion
	| llamada
	| prim
	| funcion_predefinida
	| sentenciaIF
	| sentenciaWHILE
	;


bloque	
scope {
	int linea;
}
@init {
	
	Interprete.getTablaSimbolos().entrar();
}	
@after {
	enviar("<fin_bloque></fin_bloque>");
	Interprete.getTablaSimbolos().salir();
}
	:
	^(BLOQUE { enviar("<ini_bloque><linea>" + $BLOQUE.line + "</linea></ini_bloque>");} elemento_bloque*) 
	;

elemento_bloque
	:	declaracion_variables
	|	sentencia
	;


declaracion_variables 	
scope {

	String tipo;
	String nombre;
	Integer longitud;
}
@init {

	$declaracion_variables::longitud = -1; // Muchas veces se usa -1 como flag
}

@after {

}	
	:
		^(DECL tipo_base {$declaracion_variables::tipo = $tipo_base.valor; } declaracion_var_asig+)	
	;
	
declaracion_var_asig

scope {
	String tipo;
}
@init {
	$declaracion_var_asig::tipo = $declaracion_variables::tipo;

}
	:	 declaracion_variable asignacion?
	;


declaracion_variable
scope {
	String nombre;
	Integer longitud;

}
@init {
	$declaracion_variable::nombre = "";
	$declaracion_variables::longitud = -1;
	$declaracion_variable::longitud = -1;

}

	:	^(DECL_VAR ^(NOMBRE_VAR a=IDENT))
		{ 
		  $declaracion_variable::nombre = $a.text;
		  $declaracion_variables::nombre = $declaracion_variable::nombre;
		  Interprete.getTablaSimbolos().declararVariable($a.text, $declaracion_variables::tipo); 
		  enviar("<variable><nombre>" + $a.text + "</nombre><tipo>" + $declaracion_variables::tipo 
		  	+ "</tipo><linea>" + $a.line + "</linea></variable>");
		} 
	|	^(DECL_VAR_ARR ^(NOMBRE_VAR a=IDENT) ^(LONGITUD expr))
		{
		  $declaracion_variable::nombre = $a.text;
		  $declaracion_variables::nombre = $declaracion_variable::nombre;
		  $declaracion_variable::longitud = (Integer) $expr.valor.get();
		  $declaracion_variables::longitud = $declaracion_variable::longitud;
		  Interprete.getTablaSimbolos().declararVariable($a.text, $declaracion_variables::tipo, (Integer) $expr.valor.get() );
		  enviar("<variable><nombre>" + $a.text + "</nombre><tipo>" 
		  	+ $declaracion_variables::tipo + "</tipo><longitud>" + $expr.valor.get() 
		  	+ "</longitud><linea>" + $a.line + "</linea></variable>");
			
		}	
	|	^(DECL_VAR_REF ^(NOMBRE_VAR a=IDENT))
		{
		  $declaracion_variable::nombre = $a.text;
		  $declaracion_variables::nombre = $declaracion_variable::nombre;
		  
		  Interprete.getTablaSimbolos().declararVariable($a.text, $declaracion_variables::tipo, true);
		  enviar("<variable><nombre>" + $a.text + "</nombre><tipo>" + $declaracion_variables::tipo + "</tipo>" 
		  	+ "<esReferencia>TRUE</esReferencia>" + "<linea>" + $a.line + "</linea></variable>");
		
		}
	;	




asignacion
options {
	backtrack = true; //Necesitamos para que distinga expr de listaExpr, que mire en profundidad
}
scope {
	String tipo; //El tipo de la asignacion, se va a usar para la autoconversion de tipos
	boolean enDeclaracion;
	String nombre;
	Integer longitud;
}
@init {
	
	
	try {
		String tipo = $declaracion_variables::tipo;
		$asignacion::tipo = tipo;
		$asignacion::enDeclaracion = true;
		$asignacion::nombre = $declaracion_variables::nombre;
		$asignacion::longitud = $declaracion_variables::longitud;
		
	} catch (java.util.EmptyStackException e) { // Si falla es porque no estamos en $declaracion_variables
		$asignacion::enDeclaracion = false;
		$asignacion::nombre = $sentencia_asignacion::nombre;
		$asignacion::tipo = $sentencia_asignacion::tipo;
		$asignacion::longitud = $sentencia_asignacion::indice;
	}
}
@after {
	
}
	:	^(ASIGNACION ^(EXPRESION expr))
		{ 
		 
		  if ($asignacion::longitud == -1) { //No es un array
		  	Interprete.getTablaSimbolos().setValor($asignacion::nombre, $expr.valor); 
		  	if ($expr.valor.get() instanceof Variable) {
		  		enviar("<asignacion><nombre>" + $asignacion::nombre + "</nombre><valor>" + $expr.valor 
		  			+ "</valor><ref>" + ((Variable) $expr.valor.get()).getNombre() + "</ref><linea>" 
		  			+ $EXPRESION.line + "</linea></asignacion>");
		  	} else {
		  		enviar("<asignacion><nombre>" + $asignacion::nombre + "</nombre><valor>" + $expr.valor 
		  			+ "</valor><linea>" + $EXPRESION.line + "</linea></asignacion>");
		  	}
		  } else {
		  	Interprete.getTablaSimbolos().setValor($asignacion::nombre, $expr.valor, $asignacion::longitud); 
		  	enviar("<asignacion><nombre>" + $asignacion::nombre + "</nombre><valor>" + $expr.valor + "</valor><indice>" + $asignacion::longitud + "</indice><linea>" + $EXPRESION.line 
		  		+ "</linea></asignacion>");
		  }
		  
		}
		
	|	^(ASIGNACION ^(EXPRESION listaExpr[false]))
		{
		  //No hace falta comprobar , sabemos que es un array
		  List<Valor> listaValores = $listaExpr.listaValores;
		  Iterator<Valor> iteValor = listaValores.iterator();
		  int i=0;
		  while(iteValor.hasNext()) {
		  	Valor valor = iteValor.next();
		  	Interprete.getTablaSimbolos().setValor($asignacion::nombre, valor, i); 
		  	enviar("<asignacion><nombre>" + $asignacion::nombre + "</nombre><valor>" + valor 
		  		+ "</valor><indice>" + i + "</indice><linea>" + $EXPRESION.line + "</linea></asignacion>");	
		  	i++;
		  }
		

		}
	|	^(ASIGNACION_REF ^(EXPRESION IDENT))
		{ 
		 
		 	Variable variable = Interprete.getTablaSimbolos().getVariable($IDENT.text); 
			Interprete.getTablaSimbolos().setValor($asignacion::nombre, new Valor<Variable>(variable)); 
		 	enviar("<asignacion><nombre>" + $asignacion::nombre + "</nombre><nombreRef>" 
		 		+ variable.getNombre() + "</nombreRef><linea>" + $EXPRESION.line + "</linea></asignacion>");
		 
		}
	;
	
	
nombre_variable
scope {
	String nombre;
	String tipo;
	Integer indice;
}
@init {
	$nombre_variable::indice = -1;
}
@after {
	//Volcamos para que pueda leer $asignacion
	$sentencia_asignacion::nombre = $nombre_variable::nombre;
	$sentencia_asignacion::tipo = $nombre_variable::tipo;
	$sentencia_asignacion::indice = $nombre_variable::indice;

}
	:
		
		^(NOMBRE_VAR IDENT { $nombre_variable::nombre = $IDENT.text; 
				     $nombre_variable::tipo = "int"; 
				   } ) 
			^(INDICE expr { $nombre_variable::tipo = Interprete.getTablaSimbolos().getTipo($IDENT.text); 
					$nombre_variable::indice = (Integer) $expr.valor.get(); })
	|	^(NOMBRE_VAR IDENT { $nombre_variable::nombre = $IDENT.text; 
				     $nombre_variable::tipo = Interprete.getTablaSimbolos().getTipo($IDENT.text);})
	;

sentencia_asignacion 
scope {
	String nombre;
	Integer indice;
	String tipo;
}
@init {
	$sentencia_asignacion::indice = -1;
}
	:
		^(SENTENCIA_ASIG nombre_variable asignacion)
	;	
	

llamada returns [Valor valor, String tipo]
scope {
	Valor valorRetorno;
	boolean ejecutable;
}
@init {
	
	
	Funcion funcion = null;
	List<ParametroFuncion> listaParametros= new ArrayList<ParametroFuncion>();
	$llamada::ejecutable = true;	
	
}
@after {
	enviar("<fin_bloque></fin_bloque>");
	if ($llamada::valorRetorno == null) {
		enviar("<fin_llamada></fin_llamada>");
	} else {
		enviar("<fin_llamada><retorno>" + $llamada::valorRetorno + "</retorno></fin_llamada>");
	}
	
}
	:
		^(LLAMADA ^(NOMBRE_FUNC IDENT {
				funcion = Interprete.getTablaSimbolos().getFuncion($IDENT.text); 
				}) ^(PARAM_ACTUAL listaExpr[false]) )
		{	
			
			if(! $IDENT.text.equals("system")) {
				//System.out.println("EMPIEZA LA EJECUCION DE " + $IDENT.text);
				Iterator<Valor> iteValores = $listaExpr.listaValores.iterator();
				
				while(iteValores.hasNext()) {
					Valor valor = iteValores.next();
					listaParametros.add(new ParametroFuncion(valor));
				}
				enviar("<ini_llamada><nombre>" + $IDENT.text + "</nombre><linea>" + $IDENT.line 
					+ "</linea></ini_llamada>");
				
				// Hay que generar este bloque para que se puedan situar las variables de los parametros formales.
				enviar("<ini_bloque></ini_bloque>");
				
				// TablaSimbolos.iniciarEjecucion realiza declaraciones internamente por lo que
				// hay que pasarle una referencia a Interprete para que pueda enviar los mensajes.
				Interprete.getTablaSimbolos().iniciarEjecucion(funcion,listaParametros,interprete);
				
				
				
				flujo.push(funcion.getIndiceFlujo());
				bloque();
				flujo.pop();
				Interprete.getTablaSimbolos().finalizarEjecucion();
				$valor = $llamada::valorRetorno;
				$tipo = funcion.getTipoRetorno();
				
			}
			
			//System.out.println(" : " + $listaExpr.listaValores.toString() );
			
		 }
	|	^(LLAMADA ^(NOMBRE_FUNC IDENT) {funcion = Interprete.getTablaSimbolos().getFuncion($IDENT.text); }) {
			
			
			if(! $IDENT.text.equals("system")) {
				//System.out.println("EMPIEZA LA EJECUCION DE " + $IDENT.text);
				Interprete.getTablaSimbolos().iniciarEjecucion(funcion);
				enviar("<ini_llamada><nombre>" + $IDENT.text + "</nombre><linea>" + $IDENT.line 
					+ "</linea></ini_llamada>");
				flujo.push(funcion.getIndiceFlujo());
				bloque();
				flujo.pop();
				Interprete.getTablaSimbolos().finalizarEjecucion();
				$valor = $llamada::valorRetorno;
				$tipo = funcion.getTipoRetorno();
			} 
			//$tipo = "CALL";
			
			
		}
	;
	

sentenciaIF
scope {
	int tipo;
	int ini; //Para tener una referencia desde la que empezar a buscar el nodo
	// 0 : if-else
	// 1 : if
	int linea;
}
@init {
	$sentenciaIF::ini = input.index();
}
@after {
	
	CommonTree nodo = (CommonTree) $sentenciaIF.start.getChild(1);
	System.out.println(nodo.toStringTree());
	int i;
	// Si es true
	if ((Integer) $a.valor.get() != 0) {
		enviar("<condicional><linea>" + $sentenciaIF::linea 
			+ "</linea><ramaElegida>PRINCIPAL</ramaElegida></condicional>");
		nodo = (CommonTree) $sentenciaIF.start.getChild(1);
	} else {
		if ($sentenciaIF.start.getChild(2) != null) {
			enviar("<condicional><linea>" + $sentenciaIF::linea 
				+ "</linea><ramaElegida>ELSE</ramaElegida></condicional>");
			nodo = (CommonTree) $sentenciaIF.start.getChild(2);
		} else {
			enviar("<condicional></condicional>");
		}
	}
	i = $sentenciaIF::ini;
        boolean encontrado = false;
	while(!encontrado && i<= input.index() ) {
		if(flujo.get(i) == nodo) {
			encontrado = true;
		} else {
			i++;
		}	
	}
	flujo.push(i);
	
	sentencia();
	flujo.pop();
	
}
	:
		^(IF ^(EXPRESION a=expr) {
			$sentenciaIF::ini = input.index(); 
			$sentenciaIF::linea = $EXPRESION.line;  } . .) 
			{ $sentenciaIF::tipo = 0; }
	;
	
sentenciaWHILE
scope {
	boolean terminado;
	int ini;
	int linea;
}
@after {
	CommonTree nodoExpr=(CommonTree)$sentenciaWHILE.start.getChild(0);
	CommonTree nodoSentencia=(CommonTree)$sentenciaWHILE.start.getChild(1);
	
	int cond;
	int i;
	int fin = flujo.index();
	boolean encontrado;
	
	$sentenciaWHILE::terminado=false;
	while(! $sentenciaWHILE::terminado){
		
		i = $sentenciaWHILE::ini;
		encontrado = false;
		while(!encontrado && i<=fin) {
			if(nodoExpr == flujo.get(i)) {
				encontrado = true;
			} else {
				i++;
			}
		}
		flujo.push(i);
        	cond=(Integer)expr().get();
        	flujo.pop();
        	if (cond == 0) {
        		enviar("<loop><linea>" + $sentenciaWHILE::linea + "</linea><sigue>FALSE</sigue></loop>");
        		break;
        	} else {
        		enviar("<loop><linea>" + $sentenciaWHILE::linea + "</linea><sigue>TRUE</sigue></loop>");
        	}
        	
        	i = $sentenciaWHILE::ini;
		encontrado = false;
		while(!encontrado && i<=fin) {
			if(nodoSentencia == flujo.get(i)) {
				encontrado = true;
			} else {
				i++;
			}
		}
        	flujo.push(i);
        	sentencia();
        	flujo.pop();
        }
}
	:	^(WHILE { $sentenciaWHILE::ini = flujo.index(); $sentenciaWHILE::linea = $WHILE.line; } . .)
	;	
	



expr returns [Valor valor]
@init {
	
}
@after {
	
}

		
	:
		funcion_predefinida { $valor = $funcion_predefinida.valor; }
	|	
	
		^(OR a=expr b=expr) {
			//Primero miramos el valor de la izda, si es true se acabo
			if ((Integer)$a.valor.get() != 0) {
				$valor = new Valor<Integer>(1);
			} else {
				$valor = $b.valor;
			}
				
		
		}
	
	|	^(AND a=expr b=expr) {
			//Primero miramos el valor de la izda, si es false se acabo
			if ((Integer)$a.valor.get() == 0) {
				$valor = new Valor<Integer>(0);
			} else {
				$valor = $b.valor;
			}
	
		}
		
	
	|	^(IGUAL a=expr b=expr) {
			if( $a.valor.get() instanceof Integer) { 
				if ( $b.valor.get() instanceof Integer) {
					$valor = ( ( (Integer) $a.valor.get() ).equals( (Integer) $b.valor.get() ) )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else  {
					if ( $b.valor.get() instanceof Double) { // Si es float
						$valor = ( ( (Integer) $a.valor.get() ).equals( ((Double) $b.valor.get()).intValue() ) )? 
						new Valor<Integer>(1) : new Valor<Integer>(0); 
					} else { //.. probablemente sea Character
						$valor = ( ((Integer) $a.valor.get() ).equals( (int) ((Character) $b.valor.get()).charValue() )  )? 
						new Valor<Integer>(1) : new Valor<Integer>(0);
					}
				}
			} else if($a.valor.get() instanceof Double) {
				// Conversion automatica para casos como por ejemplo (2.0 == 2)
				if($b.valor.get() instanceof Integer) {
					$valor = ( ((Double) $a.valor.get()).equals((Integer) $b.valor.get() * 1.0 ))? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else  { // Si es double normalmente
					$valor = ( ((Double) $a.valor.get()).equals((Double) $b.valor.get()) )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else if($a.valor.get() instanceof Character) {
				$valor = ( ((Character) $a.valor.get() ).equals( (Character) $b.valor.get() )  )? 
				new Valor<Integer>(1) : new Valor<Integer>(0);
			} else {
				System.out.printf("ERROR: tipo no reconocido");
			}
		}
	|	^(DISTINTO a=expr b=expr) { 
			if( $a.valor.get() instanceof Integer) { 
				if ( $b.valor.get() instanceof Integer) {
					$valor = ( ( (Integer) $a.valor.get() ).equals( (Integer) $b.valor.get() ) )? 
					new Valor<Integer>(0) : new Valor<Integer>(1); 
				} else  { 
					if ( $b.valor.get() instanceof Double) { // Si es float
						$valor = ( ( (Integer) $a.valor.get() ).equals( ((Double) $b.valor.get()).intValue() ) )? 
						new Valor<Integer>(0) : new Valor<Integer>(1); 
					} else { //.. probablemente sea Character
						$valor = ( ((Integer) $a.valor.get() ).equals( (int) ((Character) $b.valor.get()).charValue() )  )? 
						new Valor<Integer>(0) : new Valor<Integer>(1);
					}
				}
			} else if($a.valor.get() instanceof Double) {
				// Conversion automatica para casos como por ejemplo (2.0 == 2)
				if($b.valor.get() instanceof Integer) {
					$valor = ( ((Double) $a.valor.get()).equals((Integer) $b.valor.get() * 1.0 ))? 
					new Valor<Integer>(0) : new Valor<Integer>(1); 
				} else  { // Si es double normalmente
					$valor = ( ((Double) $a.valor.get()).equals((Double) $b.valor.get()) )? 
					new Valor<Integer>(0) : new Valor<Integer>(1); 
				}
			} else if($a.valor.get() instanceof Character) {
				$valor = ( ((Character) $a.valor.get() ).equals( (Character) $b.valor.get() )  )? 
				new Valor<Integer>(0) : new Valor<Integer>(1);
			} else {
				System.out.printf("ERROR: tipo no reconocido");
			}
		}
	|	^(MAYOR a=expr b=expr) { 
			if( $a.valor.get() instanceof Integer) { 
				if ($b.valor.get() instanceof Integer) {
					$valor = ((Integer) $a.valor.get() > (Integer) $b.valor.get())? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else {
					$valor = ((Integer) $a.valor.get() > ((Double) $b.valor.get()).intValue() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else if($a.valor.get() instanceof Double) {
				if($b.valor.get() instanceof Integer) {
					$valor = ( (Double) $a.valor.get() > (Integer) $b.valor.get() * 1.0 )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else {
					$valor = ((Double) $a.valor.get() > (Double) $b.valor.get())? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else 
			if ($a.valor.get() instanceof Character) { 
				if ($b.valor.get() instanceof Integer) { // Si el segundo operando es un entero...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) > (Integer) $b.valor.get() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				} else if ($b.valor.get() instanceof Character) { // Si el segundo operando es un caracter...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) > ((int) ( (Character)$b.valor.get() ).charValue() ) )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				}
			} else {
				System.out.printf("ERROR: tipo no reconocido");
			}
		}
	|	^(MENOR a=expr b=expr) { 
			if( $a.valor.get() instanceof Integer) { 
				if ($b.valor.get() instanceof Integer) {
					$valor = ((Integer) $a.valor.get() < (Integer) $b.valor.get())? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else {
					$valor = ((Integer) $a.valor.get() < ((Double) $b.valor.get()).intValue() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else if($a.valor.get() instanceof Double) {
				if($b.valor.get() instanceof Integer) {
					$valor = ( (Double) $a.valor.get() < (Integer) $b.valor.get() * 1.0 )? new Valor<Integer>(1) : 
					new Valor<Integer>(0); 
				} else {
					$valor = ((Double) $a.valor.get() < (Double) $b.valor.get())? new Valor<Integer>(1) : 
					new Valor<Integer>(0);
				}
			} else 
			if ($a.valor.get() instanceof Character) { 
				if ($b.valor.get() instanceof Integer) { // Si el segundo operando es un entero...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) < (Integer) $b.valor.get() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				} else if ($b.valor.get() instanceof Character) { // Si el segundo operando es un caracter...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) < ((int) ( (Character)$b.valor.get() ).charValue() ) )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				}
			}
		}
	|	^(MAYORIGUAL a=expr b=expr) { 
			if( $a.valor.get() instanceof Integer) { 	
				if ($b.valor.get() instanceof Integer) {
					$valor = ((Integer) $a.valor.get() >= (Integer) $b.valor.get())? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else {
					$valor = ((Integer) $a.valor.get() >= ((Double) $b.valor.get()).intValue() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else if($a.valor.get() instanceof Double) {
				if($b.valor.get() instanceof Integer) {
					$valor = ( (Double) $a.valor.get() >= (Integer) $b.valor.get() * 1.0 )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else {
					$valor = ((Double) $a.valor.get() >= (Double) $b.valor.get())? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else 
			if ($a.valor.get() instanceof Character) { 
				if ($b.valor.get() instanceof Integer) { // Si el segundo operando es un entero...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) >= (Integer) $b.valor.get() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				} else if ($b.valor.get() instanceof Character) { // Si el segundo operando es un caracter...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) >= ((int) ( (Character)$b.valor.get() ).charValue() ) )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				}
			}
		}
	|	^(MENORIGUAL a=expr b=expr) { 
			if( $a.valor.get() instanceof Integer) {
				if ($b.valor.get() instanceof Integer) {
					$valor = ((Integer) $a.valor.get() <= (Integer) $b.valor.get())? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else {
					$valor = ((Integer) $a.valor.get() <= ((Double) $b.valor.get()).intValue() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else if($a.valor.get() instanceof Double) {
				if($b.valor.get() instanceof Integer) {
					$valor = ( (Double) $a.valor.get() <= (Integer) $b.valor.get() * 1.0 )? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				} else {
					$valor = ((Double) $a.valor.get() <= (Double) $b.valor.get())? 
					new Valor<Integer>(1) : new Valor<Integer>(0); 
				}
			} else 
			if ($a.valor.get() instanceof Character) { 
				if ($b.valor.get() instanceof Integer) { // Si el segundo operando es un entero...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) <= (Integer) $b.valor.get() )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				} else if ($b.valor.get() instanceof Character) { // Si el segundo operando es un caracter...
					$valor = ( ((int) ( (Character)$a.valor.get() ).charValue() ) 
						<= ((int) ( (Character)$b.valor.get() ).charValue() ) )? 
					new Valor<Integer>(1) : new Valor<Integer>(0);
				}
			}
		}
		
	|
		// Las operaciones se soportan solo para tipos numericos
		^(MAS a=expr b=expr) 
		{ 
			if ($a.valor.get() instanceof Integer) {
				if ($b.valor.get() instanceof Integer) {
					$valor = new Valor<Integer>((Integer)$a.valor.get() 
						+ (Integer)$b.valor.get() ); 
				} else {
					$valor = new Valor<Integer>((Integer)$a.valor.get() 
						+ ((Double)$b.valor.get()).intValue() );
				}
			} else 
			if ($a.valor.get() instanceof Double) {
				if ($b.valor.get() instanceof Double) {
					$valor = new Valor<Double>((Double)$a.valor.get() 
						+ (Double)$b.valor.get());
				} else if ($b.valor.get() instanceof Integer) {
					$valor = new Valor<Double>((Double)$a.valor.get() 
						+ (Integer)$b.valor.get() * 1.0);
				}
			}
			  else 
			if ($a.valor.get() instanceof Character) { 
				if ($b.valor.get() instanceof Integer) { // Si el segundo operando es un entero...
					$valor = new Valor<Character>( 
						(char) ( ((int) ( (Character)$a.valor.get() ).charValue() ) 
						+ (Integer) $b.valor.get() ));
				} else if ($b.valor.get() instanceof Character) { // Si el segundo operando es un caracter...
					$valor = new Valor<Character>( 
						(char) ( ((int) ( (Character)$a.valor.get() ).charValue() ) 
						+ ((int) ( (Character)$b.valor.get() ).charValue() ) ));
				}
			}
		}
	|	^(MENOS a=expr b=expr) 
		{ 	
			if ($a.valor.get() instanceof Integer) {
				if ($b.valor.get() instanceof Integer) {
					$valor = new Valor<Integer>((Integer)$a.valor.get() 
						- (Integer)$b.valor.get() ); 
				} else {
					$valor = new Valor<Integer>((Integer)$a.valor.get() 
						- ((Double)$b.valor.get()).intValue() );
				}
			} else 
			if ($a.valor.get() instanceof Double) {
				if ($b.valor.get() instanceof Double) {
					$valor = new Valor<Double>((Double)$a.valor.get() 
						- (Double)$b.valor.get());
				} else if ($b.valor.get() instanceof Integer) {
					$valor = new Valor<Double>((Double)$a.valor.get() 
						- (Integer)$b.valor.get() * 1.0);
				}
			}
			  else 
			if ($a.valor.get() instanceof Character) { 
				if ($b.valor.get() instanceof Integer) { // Si el segundo operando es un entero...
					$valor = new Valor<Character>( 
						(char) ( ((int) ( (Character)$a.valor.get() ).charValue() ) 
						- (Integer) $b.valor.get() ));
				} else if ($b.valor.get() instanceof Character) { // Si el segundo operando es un caracter...
					$valor = new Valor<Character>( 
						(char) ( ((int) ( (Character)$a.valor.get() ).charValue() ) 
						- ((int) ( (Character)$b.valor.get() ).charValue() ) ));
				}
			}
		} 
	
	|	^(NOT a=expr)
		{
			if ($a.valor.get() instanceof Integer) {
				if ((Integer)$a.valor.get() == 0) {
					$valor = new Valor<Integer>(1);
				} else {
					$valor = new Valor<Integer>(0);
				} 
			}
		}
	|	^(NEGAR a=expr)
		{	
			if ($a.valor.get() instanceof Integer) {
				$valor = new Valor<Integer>(-(Integer)$a.valor.get()); 
			} else 
			if ($a.valor.get() instanceof Double) {
				$valor = new Valor<Double>(-(Double)$a.valor.get());
			}
		}
	
	|	^(PROD a=expr b=expr) 
		{
		  if ($a.valor.get() instanceof Integer) {
		  	$valor = new Valor<Integer>((Integer)$a.valor.get() * (Integer)$b.valor.get());  
		  } else 
		  if ($a.valor.get() instanceof Double) {
		  	if (b.get() instanceof Double) {
                      		valor = new Valor<Double>((Double)a.get() * (Double)b.get());
                      	} else if (b.get() instanceof Integer){
                      		valor = new Valor<Double>((Double)a.get() * (Integer)b.get() * 1.0);
                      	}
		  }
		}  
		  
	|	^(DIV a=expr b=expr) { 
			if ($a.valor.get() instanceof Integer) {
				$valor = new Valor<Integer>((Integer)$a.valor.get() / (Integer)$b.valor.get()); 
			} else 
			if ($a.valor.get() instanceof Double) {
				if (b.get() instanceof Double) {
                      			valor = new Valor<Double>((Double)a.get() / (Double)b.get());
                      		} else if (b.get() instanceof Integer){
                      			valor = new Valor<Double>((Double)a.get() / (Integer)b.get() * 1.0);
                      		}
			}
		}
	|	^(MOD a=expr b=expr) { 
		
			$valor = new Valor<Integer>((Integer)$a.valor.get() \% (Integer)$b.valor.get()); 
		
		}
	|	atom { 
		$valor = $atom.valor;
		/** CONVERSION DE TIPOS
		*   ===================
		*   	
		*   Se realiza la comparacion entre el tipo destino y el actual.
		*   Si no coinciden se intenta convertir.
		*
		**/
		try {
			String tipo = $asignacion::tipo;
			
			//  
			//echo ("El tipo destino es " + tipo + "y el otro es " + $atom.tipo + /**"y vale" + $atom.valor.get()*/);
			//
			if (!tipo.equals($atom.tipo) && !$atom.tipo.equals("expr")) {
				
				if (tipo.equals("int")) { // Si el objetivo es integer
					try {
						if ($atom.tipo.equals("char")) {
							//Si es una variable hay que mirar dentro.
			
							if ($atom.valor.get() instanceof Variable) {
								$valor = new Valor<Integer>( 
									(int)  ( (Character) $atom.valor.get() ).charValue() );
							} else { 
								if ($atom.valor.get() instanceof Character) {
									$valor = new Valor<Integer>( 
										(int)  ( (Character) $atom.valor.get() ).charValue() );
								} else { // No es una Character, probablemente sera un Integer
									$valor = new Valor<Integer>( (Integer) $atom.valor.get() ); 
								}
							}
							
						} else {	
							$valor = new Valor<Integer>( ((Double) $atom.valor.get()).intValue() );
						}
					} catch (Exception e) {
						System.out.println("ERROR: fallo en conversion");
						e.printStackTrace();
					}
				}
				if (tipo.equals("float")) { //Si el objetivo es float
					
					$valor = new Valor<Double>( (Integer) $atom.valor.get() * 1.0 );
				}
				
			}
		} catch (java.util.EmptyStackException e) {
			// Si entramos aqui es porque no estamos bajo un tipo objetivo
			// Como puede ser normal no imprimimos traza
		}
		
		}
	;	
	
prim returns [Valor valor]
	:	^(PREFIJO ^(NOMBRE_VAR IDENT) ^(INT num=INT)) {
			Variable variable = Interprete.getTablaSimbolos().getVariable($IDENT.text); 
			$valor = variable.getValor(); 
			// En prefijo mandamos "valor" actualizado
			$valor = new Valor<Integer>((Integer)$valor.get() + Integer.parseInt($num.text) );
			Interprete.getTablaSimbolos().setValor($IDENT.text, $valor);
			enviar("<asignacion><nombre>" + $IDENT.text + "</nombre><valor>" 
				+ (Integer)$valor.get() + "</valor><linea>" + $IDENT.line + "</linea></asignacion>");
			
		}
	|	^(POSTFIJO ^(NOMBRE_VAR IDENT) ^(INT num=INT)) {
			Variable variable = Interprete.getTablaSimbolos().getVariable($IDENT.text); 
			// En postfijo "valor" se queda así. Se actualiza en la tabla de simbolos pero lo que se manda
			// a evaluar es el valor viejuno.
			$valor = variable.getValor();
			Interprete.getTablaSimbolos().setValor(
				$IDENT.text, new Valor<Integer>((Integer)$valor.get() + Integer.parseInt($num.text) ) );
			// Internamente respetamos la esencia del postfijo, es decir, mandamos valor desactualizado
			// pero al simulador le mandamos el valor actualizado por coherencia
			variable = Interprete.getTablaSimbolos().getVariable($IDENT.text); 
			Valor valorSimulacion = variable.getValor();
			enviar("<asignacion><nombre>" + $IDENT.text 
				+ "</nombre><valor>" + (Integer) valorSimulacion.get() + "</valor><linea>" 
				+ $IDENT.line + "</linea></asignacion>");
				
		}
	;
	



listaExpr[boolean debeImprimir] returns [List<Valor> listaValores]
scope {
	String tipo_tmp;

}
@init {
	listaValores = new ArrayList<Valor>();
	
	
}
@after {
	//int i;
	//for(i=0;i<=listaValores.size() - 1; i++) {
	//	System.out.println("-- " + listaValores.get(i).toString());
	//}
	
	try {  // Restablecemos el tipo de la asignacion si se ha falseado
		boolean prueba = $llamada::ejecutable;
		$asignacion::tipo = $listaExpr::tipo_tmp;
	} catch (java.util.EmptyStackException e) 
	{  /*Se da esta excepcipn cuando no estamos en una asignacion, es normal.*/}
}
	:	
		{
			// Si estamos en una llamada hay que falsear el tipo para 
			// evitar que se haga casting de un parametro a la asignacion
			// Por ejemplo: char la = hacerSuma(numero);  
			//	Hay que evitar que numero:int se convierta a char.
			//	La conversion solo debe aceptar al retorno en hacerSuma
			try {	
				// Si no estamos bajo llamada se saldra por la expcecion
				boolean prueba = $llamada::ejecutable;
				// Si no estamos bajo una asignacion se saldra por la excepcion
				$listaExpr::tipo_tmp = $asignacion::tipo;
				$asignacion::tipo = "NO_CONVERTIR";
			} catch (java.util.EmptyStackException e) 
			{  /*Se da esta excepcipn cuando no estamos en una asignacion, es normal.*/}
		
		}
		a=expr {
			 if($debeImprimir) $imprimir::listaImprimir.add((Object) $a.valor.get()); 
			 listaValores.add($a.valor);
			
			
			} ( b=expr { if($debeImprimir) $imprimir::listaImprimir.add((Object) $b.valor.get()); 
				       listaValores.add($b.valor); })* // CUIDADO 
		
	;



atom returns [Valor valor, String tipo]
scope {
	boolean ejecutable;
	String tipo_tmp;
}
@init {
	
	
}
@after {
	
}
	:	LPAR expr RPAR	{$valor = $expr.valor; $tipo = "expr";}
	|	prim {$valor = $prim.valor;}
	|	INT {$valor = new Valor<Integer>(Integer.parseInt($INT.text)); $tipo = "int";}
	|	FLOAT {$valor = new Valor<Double>(Double.parseDouble($FLOAT.text)); $tipo = "float";} 
	|	STRING {$valor = new Valor<String>($STRING.text); $tipo = "string";  }
	|	CHAR {
			String carStr = $CHAR.text; 
			// Hay que librarse de las comillas..
			carStr = carStr.replace("\"","");
			Character caracter = null;
			if (carStr.length() > 3) { // Si tras quitar comillas mide mas que uno...
				// ... es porque hay un escape y lo normal es que sea porque
				// se trata de \0 (final de array)
				caracter = '\0';
			} else {
				caracter = carStr.charAt(1);
			}
			//$valor = new Valor<Character>($CHAR.text.charAt(1)); $tipo = "char"; 
			$valor = new Valor<Character>(caracter); $tipo = "char";
		}
	|	IDENT LCOR {
		try {
			$atom::tipo_tmp = $asignacion::tipo;
			$asignacion::tipo = "int";
		} catch (java.util.EmptyStackException e) 
		{  /*Se da esta excepcopn cuando no estamos en una asignacion, es normal.*/}
		
		} expr RCOR { 
			try {
				$asignacion::tipo = $atom::tipo_tmp; 
			} catch (java.util.EmptyStackException e) {  /***/ }
			Variable variable = Interprete.getTablaSimbolos().getVariable($IDENT.text); 
			$valor = variable.getValor((Integer) $expr.valor.get()); $tipo = variable.getTipo(); }
	|	IDENT { Variable variable = Interprete.getTablaSimbolos().getVariable($IDENT.text); 
			$valor = variable.getValor(); $tipo = variable.getTipo(); } 
	|	llamada {$valor = $llamada.valor; $tipo = $llamada.tipo; }
	;

leer
scope {
	String entrada;
}
@init {
	
}	
@after {
	
}
	:	^(F_LEER ^(FORMATO STRING) ^(NOMBRE_VAR IDENT 
		{
			enviar("<entrada><nombre>" + $IDENT.text + "</nombre><linea>" + $IDENT.line + "</linea></entrada>");
			final String nombre = $IDENT.text;
			
			$leer::entrada = leerStdin(nombre);
			
			if ( $STRING.text.indexOf("\%d") != -1) { 
				// Vamos a permitir que el usuario introduzca float.
				// Asi que habra que filtrar por si acaso.
								
				String [] entradaArr = $leer::entrada.split("\\.");
				$leer::entrada = entradaArr[0];
					
				Interprete.getTablaSimbolos().setValor($IDENT.text, 
					new Valor<Integer>(Integer.parseInt($leer::entrada)) );
			} else if ( $STRING.text.indexOf("\%s") != -1) {
				Interprete.getTablaSimbolos().setValor($IDENT.text, 
					new Valor<String>($leer::entrada) );
			} else if ( ($STRING.text.indexOf("\%f") != -1) || ($STRING.text.indexOf("\%lf") != -1) ){
				// Con los float no tenemos ese problema ya que parseDouble admite un formato entero.
				Interprete.getTablaSimbolos().setValor($IDENT.text, 
					new Valor<Double>(Double.parseDouble($leer::entrada)) );
			} else if ( $STRING.text.indexOf("\%c") != -1) {
				Interprete.getTablaSimbolos().setValor($IDENT.text, 
					new Valor<Character> ((Character) $leer::entrada.charAt(0)) );
			}
			enviar("<asignacion><nombre>" + $IDENT.text + "</nombre><valor>" 
				+ $leer::entrada + "</valor><linea>" + $IDENT.line + "</linea></asignacion>");
			// Mandamos salida para que haya eco en la salida estandar
			echo($leer::entrada + "\n");
			
		}))
		
	|	^(F_LEER ^(FORMATO STRING) ^(NOMBRE_VAR IDENT) ^(INDICE expr) )
		{
			enviar("<entrada><nombre>" + $IDENT.text + "[" + $expr.valor.get() + "]" 
				+ "</nombre><linea>" + $IDENT.line + "</linea></entrada>");
			final String nombre = $IDENT.text;
		
			$leer::entrada = leerStdin(nombre + "[" + $expr.valor.get() + "]");
				
			if ( $STRING.text.indexOf("\%d") != -1) { 
				// Vamos a permitir que el usuario introduzca float.
				// Asi que habra que filtrar por si acaso.
								
				String [] entradaArr = $leer::entrada.split("\\.");
				$leer::entrada = entradaArr[0];
					
				Interprete.getTablaSimbolos().setValor(
					$IDENT.text, new Valor<Integer>(Integer.parseInt($leer::entrada)), 
						(Integer) $expr.valor.get() );
			} else if ( $STRING.text.indexOf("\%s") != -1) {
				Interprete.getTablaSimbolos().setValor(
					$IDENT.text, new Valor<String>($leer::entrada), (Integer) $expr.valor.get() );
			} else if ( ($STRING.text.indexOf("\%f") != -1) || ($STRING.text.indexOf("\%lf") != -1)  ) {
				// Con los float no tenemos ese problema ya que parseDouble admite un formato entero.
				Interprete.getTablaSimbolos().setValor(
					$IDENT.text, new Valor<Double>(
						Double.parseDouble($leer::entrada)), (Integer) $expr.valor.get() );
			} else if ( $STRING.text.indexOf("\%c") != -1) {
				Interprete.getTablaSimbolos().setValor(
					$IDENT.text, new Valor<Character> ($leer::entrada.charAt(0)), 
						(Integer) $expr.valor.get() );
			}
			enviar("<asignacion><nombre>" + $IDENT.text + "</nombre><valor>" 
				+ $leer::entrada + "</valor><indice>" + $expr.valor.get() + "</indice><linea>" 
				+ $IDENT.line + "</linea></asignacion>");
			// Mandamos salida para que haya eco en la salida estandar
			echo($leer::entrada + "\n");
		}
		
	;	

imprimir
scope {
	String formato;
	List<Object> listaImprimir;
}
@init {
	$imprimir::listaImprimir = new ArrayList<Object>();
}
@after {
	String salida;
	// Vamos a soportar cuatro parametros como maximo
	// No importa que haya menos que cuatro, si es necesario lo rellenamos ahora...
	for(int i=0; i<=3; i++) {
		if ($imprimir::listaImprimir.size() - 1 < i) {
			$imprimir::listaImprimir.add(new Object());
		} else if ($imprimir::listaImprimir.get(0) instanceof Variable) {
			$imprimir::listaImprimir.set(i, ((Variable) $imprimir::listaImprimir.get(i)).getStrArrValor());
		}
	}
	try { 
	salida = String.format($imprimir::formato, $imprimir::listaImprimir.get(0), 
		$imprimir::listaImprimir.get(1), $imprimir::listaImprimir.get(2), $imprimir::listaImprimir.get(3));
	} catch(java.util.UnknownFormatConversionException e) { // String.format no soporta exactamente 
								//lo mismo que el printf de ANSI-C. Ej \%.0lf
		System.out.println("ERROR: Conversion fallida");
		salida = $imprimir::formato;
		int i=0;
		while((i <= $imprimir::listaImprimir.size() - 1) && ($imprimir::listaImprimir.get(i) != null)) {
			salida += " " + $imprimir::listaImprimir.get(i);
			i++;
		}
	}
	//salida = salida.replace("\\n",""); // Comentado porque sí que vamos a mandar saltos de línea
	echo(salida.substring(1, salida.length() - 1));
}
	:	
		^(F_IMPRIMIR ^(FORMATO STRING {enviarLinea($STRING.line); 
					$imprimir::formato = $STRING.text;}) ^(NOMBRE_VAR listaExpr[true]))
	
	|	^(F_IMPRIMIR ^(FORMATO STRING {enviarLinea($STRING.line); $imprimir::formato = $STRING.text;}))
	
	;

funcion_predefinida returns [Valor valor]
	:
		leer
	|	imprimir
	|	pow { valor = $pow.valor; }
	|	sqrt { valor = $sqrt.valor; }
	|	gets
	|	strlen { valor = $strlen.valor; }
	;
	
pow returns [Valor valor]

	:	^(F_POW a=expr b=expr) 
		{
			// Si el primer operador es integer
			if ($a.valor.get() instanceof Integer) {
				Double resultado = Math.pow((Integer)$a.valor.get() * 1.0, (Integer)$b.valor.get() * 1.0);
				Integer resultadoInt = (int) Math.floor(resultado);
				valor = new Valor<Integer>(resultadoInt);
				
			} else {
				Double resultado = Math.pow((Double)$a.valor.get(),(Double)$b.valor.get());
				valor = new Valor<Double>(resultado);
			}
			
		}
	;

sqrt returns [Valor valor]
	:	^(F_SQRT a=expr) 
		{
			if ($a.valor.get() instanceof Integer) {
				Double resultado = Math.sqrt((Integer)$a.valor.get() * 1.0);
				Integer resultadoInt = (int) Math.floor(resultado);
				valor = new Valor<Integer>(resultadoInt);
			} else {
				Double resultado = Math.sqrt((Double)$a.valor.get());
				valor = new Valor<Double>(resultado);
			}
		
		}
	;

strlen returns [Valor valor]
	:	^(F_STRLEN IDENT) 
		{
			Variable variable = Interprete.getTablaSimbolos().getVariable($IDENT.text);
			valor = new Valor<Integer>(variable.getLongitud());
		}	
	;
	
gets	:	^(F_GETS IDENT) 
		{
			enviar("<entrada><nombre>" + $IDENT.text + "</nombre><linea>" + $IDENT.line + "</linea></entrada>");
			String resultado = leerStdin($IDENT.text);
			char resultadoArr[] = resultado.toCharArray();
			Variable variable = Interprete.getTablaSimbolos().getVariable($IDENT.text);
			variable.reinicializar(); // Hay que limpiar el char array previamente
			int i=0;
			for(i=0;i<=resultadoArr.length - 1;i++) { // Intentamos copiar todos los valores, 
								//si alguno no entra Variable lo ignorara
				Interprete.getTablaSimbolos().setValor($IDENT.text, new Valor<Character>(resultadoArr[i]), i); 
				System.out.println("MIERDA");
				enviar("<asignacion><nombre>" + $IDENT.text 
					+ "</nombre><valor>" + resultadoArr[i] + "</valor><indice>" 
					+ i + "</indice><linea>" + $IDENT.line 
					+ "</linea><comentario>FALSE</comentario></asignacion>");
				//  Enviamos salida tambien para que haya eco de la entrada en la salida estandar
				echo(((Character)resultadoArr[i]).toString());
			}
			// Insertamos caracter de FIN de chararray
			Interprete.getTablaSimbolos().setValor($IDENT.text, new Valor<Character>('\0'), i); 
			enviar("<asignacion><nombre>" + $IDENT.text + "</nombre><valor>" 
				+ "END" + "</valor><indice>" + i + "</indice><linea>" + $IDENT.line 
				+ "</linea><comentario>FALSE</comentario></asignacion>");
			// Ahora hay que rellenar el resto de posiciones del array
			int j;
			for(j=i+1;j<=variable.getLongitudMAX()-1;j++) { // Como puede ver se envía "?" porque son posiciones basura
				String comentar = "FALSE";
				if (j==variable.getLongitudMAX()-1) { // En la última posición sí que se manda comentar
					comentar = "TRUE";
				}
				enviar("<asignacion><nombre>" + $IDENT.text + "</nombre><valor>" 
					+ "?" + "</valor><indice>" + j + "</indice><linea>" + $IDENT.line 
					+ "</linea><comentario>" + comentar + "</comentario></asignacion>");
			}
		}
	;

precompilacion 
@init {
	
}
@after {
	
}
	:	define
	;

define
@init {
	
}
@after {
	
}	
	:	
	^(DEFINE ^(NOMBRE_VAR l=IDENT) ^(VALOR m=atom)) 
	{ 
		enviarLinea($DEFINE.line);
		Interprete.getTablaSimbolos().declararVariable($l.text, $m.tipo); 
		Interprete.getTablaSimbolos().setValor($l.text, $m.valor);
	} 
	
	; 




