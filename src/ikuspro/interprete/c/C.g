// autor: Ivan Mosquera Paulo 
// email: ivanmosp@gmail.com
// nombreInterprete: euiti-bi_LSI_FI_C
// version:	1.0
// extensiones:	c cpp
//

// ==================== C.g : fichero de an�lisis l�xico y sint�ctico =======================


grammar C; // El nombre de la gram�tica.

options {
	output=AST; // Generar arbol AST
	ASTLabelType=CommonTree; // Tipo de objeto en los nodos
}

// Tokens imaginarios, se utilizan en las reglas sint�cticas pero no existen directamente en el nivel l�xico
tokens {
	PROGRAMA; DECLARACIONES_GLOBALES; FUNCIONES; FUNCION; CABECERA_FUNCION; BLOQUE;
	DECLARACION_NOMBRE_FUNCION; LISTA_PARAM_FORMALES; PARAM_FORMAL;
	TIPO_BASE; NOMBRE_VAR; NOMBRE_FUNC; SENTENCIA_ASIG; SENTENCIA_CALL;
	ASIGNACION; EXPRESION; LLAMADA; DEFINE; VALOR; INCLUDE; DECL_VAR;
	F_IMPRIMIR; FORMATO; F_LEER; PARAM_ACTUAL; NEGAR;
	SENTENCIAS; DECLVARS; POSTFIJO; PREFIJO; DECL_VAR_ARR; LONGITUD; PARAM_FORMAL_ARR;
	ELE_ARR; INDICE; DECL; F_POW; F_GETS; F_STRLEN; F_SQRT; DECL_VAR_REF; ASIGNACION_REF; 
}

// Lo que va en la cabecera de la clase Parser (analizador sint�ctico)
@header {
	package ikuspro.interprete.c;
	

}

// Lo que va en la cabecera de la clase Lexer (analizador l�xico)
@lexer::header { package ikuspro.interprete.c; }

// Metodos y atributos adicionales del Parser
@members {
   	// nada
}

///////////////////////////////////////////////////////////////////////////////////////
////	ANALIZADOR SINTACTICO
///////////////////////////////////////////////////////////////////////////////////////

// Un programa en C externamente esta formado por declaraciones globales.

// Las palabras en may�sculas (como EOF, PROGRAMA etc) son tokens
// Las palabras en min�sculas son reglas sint�cticas.

// La sintaxis de las reglas es:
// Se escribe primero el nombre de la regla que queremos definir (programa) y seguido ":"
// Se escribe la expresi�n que expresa todas las posibilidades que pueden formar esta regla.
// En este caso vemos que hay dos alternativas aceptables (separadas por "|")
// En cada regla nuestro objetivo es definir c�mo se va a figurar esa informaci�n en el �rbol AST 
// que m�s tarde se va a generar y que utilizar� el interprete.
// Para ello hay dos formas. En este caso tras "->" definimos una nueva parte del �rbol.
// "^" indica el comienzo de un hijo que a su vez puede tener m�s hijos.
// Por ejemplo en este caso primero est� PROGRAMA que tiene tres hijos: DECLARACIONES_GLOBALES, FUNCIONES y LLAMADA
// Estos a su vez pueden tener otros hijos como por ejemplo LLAMADA que tiene NOMBRE_FUNC
// ^(FUNCIONES funciones) por ejemplo representa una hoja en la que se pondr� el token FUNCIONES y colgar� de ah�
// lo que se genere en la regla sint�ctica "funciones"

// Otra cosa interesante en esta regla. �Cuando empieza un programa c�mo sabe el int�rprete que tiene que empezar por main?
// �D�nde se encuentra la llamada a main? El resto de las llamadas a funciones est�n definidas en el programa pero �main?
// Lo que hacemos es insertar a mano aqu� mismo una llamada a la funci�n main con "adaptor.create". 
// M�s adelate ver� que utilizamos este "truco" para otras cosas.

programa

	:	declaraciones_globales funciones EOF // EOF es el token que marca final del fichero    
		-> ^(PROGRAMA ^(DECLARACIONES_GLOBALES declaraciones_globales) ^(FUNCIONES funciones) ^(LLAMADA ^(NOMBRE_FUNC {adaptor.create(IDENT,"main")})) )
	|	funciones EOF
		-> ^(PROGRAMA ^(FUNCIONES funciones) ^(LLAMADA ^(NOMBRE_FUNC {adaptor.create(IDENT,"main")} )) ) 
		;
	

// declaraciones_globales est� formado por 1..* declaracion_global 
declaraciones_globales
	:
	declaracion_global+	// El + significa que de uno a muchos
	;
	
// funciones est� formado por 1..* funcion, no se aceptan programas sin una funci�n como m�nimo (la main)
funciones
	:
	funcion+
	;
	
// tipos basicos soportados
// El tipo string no esta en el estandar de ANSI-C
tipo_base
	:	'void' 
	|	'char' // caracteres
	| 	'int' // enteros
	|	'float' // flotantes
	|	'double' // flotantes (m�s adelante veremos que es la misma implementaci�n que float)
	//|	'string' // En un principio implement� el tipo string como prueba de concepto, en la �ltima versi�n se deja
			 // comentado para que el usuario pueda utilizar "string" como nombre de variable.
	;


// Una declaracion global puede ser una funcion o una declaracion de variable.
declaracion_global

	:	precompilacion  // veremos que en la pr�ctica son defines o includes s�lamente.
	//|	declaracion_variables // Decid� no soportar declaraciones de variables globales
	;



// Una funcion esta formada opcionalmente por :
//	cabecera_funcion Y bloque (cuando ponemos una funci�n con la cabecera y el bloque con todo el c�digo)
//		O
//	s�lo cabecera_funcion (cuando s�lo ponemos la cabecera)
//
// 

// En la segunda alternativa vemos que no se usa "->" sino que aparece el s�mbolo "!". Se trata de un segundo
// m�todo de definir el �rbol AST que en muchos casos es m�s c�modo.
// Es importante saber que no se pueden utilizar los dos m�todos al mismo tiempo
// El s�mbolo "!" significa no incluir en el AST. En este caso vemos que no generamos AST en absoluto
// en la segunda alternativa. Es una forma sencilla de soportar los programas que incluyen cabeceras separadas a parte
// de las cabeceras m�s el bloque. Ignoramos esas cabeceras separadas, total, esa informaci�n ya estar� junto al bloque.


funcion 	
	: 
		cabecera_funcion bloque -> ^(FUNCION ^(CABECERA_FUNCION cabecera_funcion) ^(bloque))
	|	cabecera_funcion! PUNTOYCOMA! 
	
	;


// Ej: sumar(parametros_formales)
// Aqu� se utiliza tamib�n la segunda alternativa de escritura AST y vemos un nuevo s�mbolo "?".
// El s�mbolo "?" significa que ese elemento es opcional.
// En este caso implica que una funcion puede no tener parametros formales. Por ejemplo "void main()".
// Vemos que exclu�mos los par�ntesis del �rbol (LPAR/RPAR), nos los necesitamos porque la estructura
// del programa ya est� impl�cita en el propio �rbol.

cabecera_funcion
	:	declaracion_nombre_funcion LPAR! lista_param_formales? RPAR!
		
	;
// Ej: int a, int b, int c

// La lista de par�metros fomales puede estar formada por un par�metro o m�s de uno separados por comas.
// El s�mbolo * significa cero o muchos. Vemos que no necesitamos las comas en el �rbol AST.

lista_param_formales
	:	param_formal ( COMA! param_formal )*
		
	;
// Ej: int a

// En esta regla hay algo interesante que ver. 
// Fij�monos en la segunda y tercera alternativa, vemos que el resultado es el mismo tanto si 
// el par�metro es un array como si el par�metro es un puntero.
// Se ha implementado as� porque primero se soport� lo m�nimo para que funcione el paso de arrays a funciones
// y m�s tarde se a�adi� soporte parcial para punteros tambi�n pero en realidad funciona igual, es paso por referencia.
// Que no se utilicen tokens espec�ficos para los punteros es por simplicidad y por el orden en que se ha desarrollado.

param_formal
	:	tipo_base IDENT -> ^(PARAM_FORMAL ^(TIPO_BASE tipo_base) ^(NOMBRE_VAR IDENT) ) // Ej: int numero
	|	tipo_base IDENT LCOR RCOR -> ^(PARAM_FORMAL_ARR ^(TIPO_BASE tipo_base) ^(NOMBRE_VAR IDENT) ) // Ej: int lista[] (arrays)
	|	tipo_base '*' IDENT ->  ^(PARAM_FORMAL_ARR ^(TIPO_BASE tipo_base) ^(NOMBRE_VAR IDENT) ) // Ej: int *p (punteros)
	;

	



// Ej: int sumar

// El tipo_base es opcional, es decir, nos sirve "void main" o "main" a secas.

declaracion_nombre_funcion
	:	IDENT -> ^(DECLARACION_NOMBRE_FUNCION ^(NOMBRE_FUNC IDENT))
	|	tipo_base IDENT -> ^(DECLARACION_NOMBRE_FUNCION ^(TIPO_BASE tipo_base) ^(NOMBRE_FUNC IDENT))
	;


// Aqu� definimos el tipo de sentencias que se pueden encontrar

sentencia 
	:	
	  bloque
	| sentencia_asignacion
	| llamada 
	| RETURN expr	->  ^(RETURN expr)
	| prim
	| funcion_predefinida
	| sentenciaIF
	| sentenciaWHILE
	| sentenciaDOWHILE
	| sentenciaFOR
	| PUNTOYCOMA!
	;

// Un bloque est� formado por cero o muchos elemento_bloque
bloque	:	
		LCURL elemento_bloque* RCURL ->	^(BLOQUE elemento_bloque*)
	;
	
// Muchas veces conviene factorizar las reglas para que se lean m�s f�cil y sean m�s f�cil
// de mantener. Este es un ejemplo.
elemento_bloque
	:	declaracion_variables
	|	sentencia
	;

// Ej: int a;

declaracion_variables

options {
	// backtrack a TRUE sirve para indicar a ANTLR que mire en profundidad para distinguir qu� alternativa utilizar.
	// Seg�n como hayamos definido las reglas puede ser necesario o no. En principio lo ideal es no necesitarlo,
	// dependiendo de nuestros conocimientos escribiremos mejores o peores reglas.
	backtrack = true;
}
scope { // En scope definimos variables globales de la regla.
	String tipo;
}

 	:	
		tipo_base  declaracion_var_asig (COMA declaracion_var_asig)* PUNTOYCOMA
	->	^(DECL tipo_base declaracion_var_asig+)
			;
		
// Una declaraci�n puede ser tambi�n una asignaci�n o no.
	
declaracion_var_asig
	:	
		declaracion_variable asignacion?
		
	;


sentenciaIF
options {
	backtrack = true;
}
	:	

		IF LPAR expr RPAR s1=sentencia  ELSE s2=sentencia -> ^(IF ^(EXPRESION expr) $s1 $s2 )
	|	IF LPAR expr RPAR sentencia -> ^(IF ^(EXPRESION expr) sentencia {adaptor.create(BLOQUE,"BLOQUE")})
	;
		

// A continuaci�n las tres reglas de bucles. Como vemos en realidad las tres se traducen en lo mismo.
// La primera regla (WHILE) es directa.
// la segunda (DO-WHILE) en realidad es un while s�lo que con sentencias por delante, ahora no se entiende bien pero
// se ver� mejor en el parser del �rbol AST o int�rprete.
// La tercera regla (FOR) en realidad si nos fijamos es una traducci�n al while equivalente.

sentenciaWHILE
	:	WHILE LPAR expr RPAR sentencia -> ^(WHILE expr sentencia)
	;	
	
sentenciaDOWHILE
	:	DO sentencia WHILE LPAR expr RPAR -> sentencia * ^(WHILE expr sentencia)
	;	

sentenciaFOR

	:	FOR LPAR ini=sentencia_asignacion PUNTOYCOMA cond=expr PUNTOYCOMA inc=sentencia RPAR cuerpo=sentencia 
		-> $ini ^(WHILE $cond ^(BLOQUE $cuerpo $inc))
	;
	

// Esta es la regla de las asignaciones.

asignacion
	:	
		ASIG expr -> ^(ASIGNACION  ^(EXPRESION expr))
	|	ASIG '*' expr -> ^(ASIGNACION ^(EXPRESION expr)) // Vamos a ignorar el operador * de punteros.
	|	ASIG listaValores -> ^(ASIGNACION ^(EXPRESION listaValores))  // Para inicializacion de arrays
	|	ASIG '&' IDENT -> ^(ASIGNACION_REF ^(EXPRESION IDENT))
	;

// Reglas de las declaraciones de variables.
declaracion_variable
	:
		IDENT LCOR expr RCOR ->  ^(DECL_VAR_ARR ^(NOMBRE_VAR IDENT) ^(LONGITUD expr))
	|	IDENT -> ^(DECL_VAR ^(NOMBRE_VAR IDENT))
	|	'*' IDENT -> ^(DECL_VAR_REF ^(NOMBRE_VAR IDENT))  // declaracion de una variable puntero
	;

nombre_variable
	:	
		IDENT LCOR expr RCOR ->  ^(NOMBRE_VAR IDENT) ^(INDICE expr)
	|	IDENT -> ^(NOMBRE_VAR IDENT)
	;

// La sentencia de asignaci�n
sentencia_asignacion 
	:
		'*' nombre_variable asignacion  // Vamos a ignorar el operador * de punteros.
		->  ^(SENTENCIA_ASIG nombre_variable asignacion)
	|	nombre_variable asignacion
		->  ^(SENTENCIA_ASIG nombre_variable asignacion)
	;

	
llamada
	:
		IDENT LPAR listaExpr RPAR -> ^(LLAMADA ^(NOMBRE_FUNC IDENT) ^(PARAM_ACTUAL listaExpr)) 
	|	IDENT LPAR RPAR -> ^(LLAMADA ^(NOMBRE_FUNC IDENT))
	;


// El tratamiento de las expresiones implica un orden establecido que se ve en c�mo vamos encadenando las reglas.
// Una regla expr est� formada por una regla orExpr (OR), que a su vez est� formada por andExpr (AND), y que a su vez
// est� formada por eqExpr (igual/distinto), y que a su vez est� formada por comparaciones, y que a su vez por sumas...
// As� hasta llegar a la regla atom que define los elementos at�micos de una expresi�n.
expr	
options{
	backtrack = true;
}
	:	
		orExpr
	
	;

listaValores
	:	LCURL! listaExpr RCURL!
	;

listaExpr
	:	COMA!? expr (COMA! expr)* // CUIDADO 
		
	;
	
orExpr	:	andExpr	(OR^ andExpr)*
	;

andExpr	:	eqExpr (AND^ eqExpr)*
	;
	
eqExpr	:	compExpr ((IGUAL|DISTINTO)^ compExpr)*
	;
	
compExpr
	:	sumExpr ((MAYOR|MENOR|MENORIGUAL|MAYORIGUAL)^ sumExpr)*
	;

sumExpr	:	multExpr ((MAS|MENOS)^ multExpr)*
	;


multExpr:	notExpr	((PROD|DIV|MOD)^ notExpr)*
	;

notExpr	:	NOT negExpr	->  ^(NOT negExpr)
	|	negExpr
	;

	
negExpr	:	

		MENOS atom	->  ^(NEGAR atom)
	|	atom		
				
	;

atom	
	:
	
		LPAR expr RPAR
	|	LPAR tipo_base RPAR expr -> expr // Reconocemos el casting explicito pero lo ignoramos, habr� programas que funciones y otros que no.
	|	prim
	|	INT
	|	FLOAT
	|	STRING
	|	CHAR
	|	IDENT LCOR expr RCOR 
	|	IDENT
	|	funcion_predefinida
	|	llamada
	
	;

// En esta regla est� la implementaci�n de "i++" "--i" etc.., lo que se hace es traducirlas a un formato com�n.
prim	:		
		IDENT MASMAS -> ^(POSTFIJO ^(NOMBRE_VAR IDENT) ^(INT { adaptor.create(INT,"1")}) )
	|	IDENT MENOSMENOS -> ^(POSTFIJO ^(NOMBRE_VAR IDENT) ^(INT { adaptor.create(INT,"-1")}) )
	|	MASMAS IDENT -> ^(PREFIJO ^(NOMBRE_VAR IDENT) ^(INT { adaptor.create(INT,"1")}) )
	|	MENOSMENOS IDENT -> ^(PREFIJO ^(NOMBRE_VAR IDENT) ^(INT { adaptor.create(INT,"-1")}) )
	;

// Ej: scanf("%d",&valor);
// Hemos optado por definir ciertas funciones directamente en el int�rprete. Esta es una de ellas.

leer	:	
		FUNCLEER LPAR STRING COMA AMPERSAND IDENT RPAR PUNTOYCOMA -> ^(F_LEER ^(FORMATO STRING) ^(NOMBRE_VAR IDENT))
	|	FUNCLEER LPAR STRING COMA AMPERSAND IDENT LCOR expr RCOR RPAR PUNTOYCOMA -> ^(F_LEER ^(FORMATO STRING) ^(NOMBRE_VAR IDENT) ^(INDICE expr) )
	;	
// Ej: printf("Resultado es %d", valor);
// Ej: printf("Mensaje");
imprimir:	
		FUNCIMPRIMIR LPAR STRING listaExpr RPAR PUNTOYCOMA -> ^(F_IMPRIMIR ^(FORMATO STRING) ^(NOMBRE_VAR listaExpr))
	|	FUNCIMPRIMIR LPAR STRING RPAR PUNTOYCOMA -> ^(F_IMPRIMIR ^(FORMATO STRING))
	;

// En esta regla se listan todas las funciones predefinidas. Como se puede ver est�n predefinidas algunas funciones 
// no est�ndar en C, que normalmente suelen requerir uso de librer�as externas como stdio.h, strings.h.
// Lo que hemos hecho por simplicidad es implementar las funciones usuales en el propio int�rprete directamente.
// Es aceptable dado que nuestro alcance no es soportar cualquier programa en C sino el subconjunto de la asignatura
// Fundamentos de Inform�tica.

funcion_predefinida
	:	
		leer
	|	imprimir
	|	pow	// Elevar a...
	|	sqrt	// Raiz cuadrada
	|	gets	// Leer array de caracteres de una vez
	|	strlen	// Longitud de un array de caracteres
	;


pow	:	
		FUNC_POW LPAR a=expr COMA b=expr RPAR  -> ^(F_POW $a $b)
	;

sqrt	:	FUNC_SQRT LPAR expr RPAR -> ^(F_SQRT expr)
	;
	
gets	:	FUNC_GETS LPAR IDENT RPAR  -> ^(F_GETS IDENT)
	;
	
strlen	:	FUNC_STRLEN LPAR IDENT RPAR  -> ^(F_STRLEN IDENT)
	;


precompilacion 
	:	define
	;

// Ej: #define PI 3.1415
define	:	('#define'|'# define') IDENT atom -> ^(DEFINE ^(NOMBRE_VAR IDENT) ^(VALOR atom))
	; 

// Hasta aqu� ha sido el an�lisis sint�ctico. A continuaci�n el l�xico pero hay que tener en cuenta 
// que en realidad se ejecutan en el orden inverso, primero el l�xico y luego el sint�ctico.
// De hecho, antes de empezar a escribir un analizador sint�ctico necesitas haber definido algunas
// reglas sint�cticas como m�nimo. Luego lo que se va haciendo es ir extendiendo.
// Un detalle, en el analizador sint�ctico como puede ver, a veces se utilizan cadenas de caracteres en lugar de tokens.
// ANTLR se encarga de convertir previamente a tokens. 

///////////////////////////////////////////////////////////////////////////////////////////////////
///	ANALIZADOR LEXICO
///////////////////////////////////////////////////////////////////////////////////////////////////


INT	:	('0'..'9')+;
// Funciones predefinidas
FUNCLEER:	'scanf'
	;
FUNCIMPRIMIR
	:	'printf'
	;
FUNC_POW
	:	'pow'
	;
FUNC_SQRT
	:	'sqrt'
	;
FUNC_GETS
	:	'gets'
	;
FUNC_STRLEN
	:	'strlen'
	;

IF	:	'if'
	;
ELSE	:	'else'
	;
WHILE	:	'while'
	;
DO	:	'do'
	;
FOR	:	'for'
	;
RETURN	:	'return'
	;
	
IDENT	:	('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;

LCURL 	:	'{';
RCURL	:	'}';
LPAR	:	'(';
RPAR	:	')';
LCOR	:	'[';
RCOR	:	']';


PUNTO	:	'.'
	;
	
PUNTOYCOMA
	:	';'
	;	
FLOAT	:	INT PUNTO INT	// Ej: 4.3
	|	PUNTO INT EXPONENTE // Ej .3E10
	|	INT PUNTO INT EXPONENTE // Ej: 4.3E10
	|	INT EXPONENTE // Ej: 2E10
	;
	
	
AMPERSAND
	:	'&';
COMA	:	',';
//operaciones
PROD	:	'*';
DIV	:	'/';
MOD	:	'%';

MASMAS	:	'++';
MENOSMENOS
	:	'--';

MAS	:	'+';
MENOS	:	'-';
ASIG	:	'=';

IGUAL	:	'==';
DISTINTO:	'!=';
NOT	:	'!';
AND	:	'&&';
OR	:	'||';
MAYOR	:	'>';
MAYORIGUAL
	:	'>=';
	
MENOR	
	:	'<' 
	;
MENORIGUAL
	:	'<=';



//  Caracteres a ignorar, no son �tiles en C
WS	:	
	(	' '
	|	'\t'
	// Saltos de linea
	|	'\n'  
	|	'\r'
	)
		{$channel=HIDDEN;} // Esto significa que estos tokens ir�n a otro canal distinto donde se ignoran.
	;
	
// Comentarios de una linea
COMENTSIMPLE
	:	'//' 
		// Cualquier cosa es parte del comentario salvo saltos de linea etc..
		~('\n'|'\r')* '\r'? '\n'
		 {$channel=HIDDEN;}
	;
	
// Comentario multilinea
COMENTCOMP
	:	'/*' ( options {greedy=false;} : . )* 
		'*/' 
		{$channel=HIDDEN;}
    	;
    	

	

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;
    
    
CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;


fragment	// Un fragment es una regla l�xica que servir� como parte de otra, no independientemente.
EXPONENTE : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

// Hay que tener en cuenta que estamos definiendo un analizador l�xico puro y duro, que tiene 
// que reconocer cada uno de los caracteres, y el fichero a analizar por ejemplo puede ser utf-8
// AntlrWORKS en su �ltima versi�n (1.3b) crea autom�ticamente las reglas sint�cticas b�sicas para ello
// si as� lo deseas.

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;



// Como hemos comentado m�s arriba en el analizador sint�ctico, lo que hemos hecho es 
// implementar directamente las funciones externas m�s utilizadas en los programas de la asignatura
// como funciones predefinidas del int�rprete. 
// Como no vamos a necesitar cargar librer�as ignoramos los includes.
LIBRERIA 
	:	
		'#' WS* 'include'  ( ~'>' )* '>'  {$channel = HIDDEN;}
	;
	// TODO deberia soportarse la sintaxis include "libreria.h" tambien
	
// Algunas funciones que en lugar de implementarlas las ignoramos directamente.
// Es el caso de fflush que no lo necesitamos porque vamos a realizar la entrada a nuestra manera
// y getc que se suele usar en los programas para que no se cierre la ventana del DOS pero
// en nuestro caso carece de sentido.

IGNORAR :
	// Ej: fflush(stdin)
		'fflush' ~(PUNTOYCOMA)* PUNTOYCOMA {$channel=HIDDEN;}
	// Ej: getc(stdin)
	|	'getc' ~(PUNTOYCOMA)* PUNTOYCOMA {$channel=HIDDEN;}
	
	;



	
