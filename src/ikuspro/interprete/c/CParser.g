parser grammar CParser;

options {
	output=AST;
	ASTLabelType=CommonTree;
	tokenVocab = CLexer;
}

@header {
	package ikuspro.analizador.c;
	import java.util.HashMap;
	import java.io.*;
	import java.util.Properties;
	
	

}

@members {
	Stack paraphrases = new Stack();
	public String getErrorMessage(RecognitionException e, String[] tokenNames){
		String msg = super.getErrorMessage(e, tokenNames);
		if (paraphrases.size()>0){
			msg=msg+" "+paraphrases.peek();
		}
		return msg;
	}
	
	public static String unquote(String a) {
      		Properties prop = new Properties();
      		try {
        	 	prop.load(new ByteArrayInputStream(("x=" + a).getBytes()));
      		}
      		catch (IOException ignore) {}
      		return prop.getProperty("x");
   	}
   	
   	public void emitErrorMessage(String s){
   		System.out.println(s);
   	}
   	
   	public void info(String s) {
   		System.out.println(s);
   	}
}

// Un programa en C externamente está formado por declaraciones globales.
programa
@init {
	info("<programa>");
}

@after {
	info("</programa>");
}
	:	declaracion_global+ EOF
	;
	

	
// Una declaración global puede ser una función o una declaración de variable.
declaracion_global
@init {
	info("<declaracion_global>");
}

@after {
	info("</declaracion_global>");
}
	:	precompilacion 
	|	funcion 
	|	declaracion_variable
	;

// Una función está formada por su cabecera y por su bloque.


funcion 	
@init {
	paraphrases.push("en funcion");
	info("<funcion>");
}

@after {
	paraphrases.pop();
	info("</funcion>");
}

	: cabecera_funcion bloque;


// Ej: sumar(parametros_formales)
cabecera_funcion
	:	declaracion_nombre_funcion LPAR lista_param_formales? RPAR
	;
// Ej: int a, int b, int c
lista_param_formales
	:	param_formal ( COMA! param_formal )*
	;
// Ej: int a
param_formal
	:	TIPOBASE IDENT;

// El tipo_base es opcional, es decir
// sirve "void main" o "main" a secas.
// Ej: int sumar
declaracion_nombre_funcion
	:	IDENT
	|	TIPOBASE IDENT
	;


// Un bloque va entre llaves y contiene declaraciones de variable y/o sentencias de asignación.
bloque	:	LCURL (declaracion_variable)* (sentencia)* RCURL;
sentencia 
	:	bloque
	| sentencia_asignacion
	| leer
	| imprimir
	| PUNTOYCOMA
	;

// Ej: int a;
declaracion_variable 	:	TIPOBASE IDENT (COMA IDENT)* PUNTOYCOMA;

sentencia_asignacion 
	: asignacion PUNTOYCOMA
	;
// Ej: i = 5 * 3;
// system("pause")
asignacion
	:	(IDENT ASIG)? expr
	;



expr	:	multExpr ((MAS|MENOS) multExpr)*
	;

listaExpr
	:	expr (COMA expr)*
	;
multExpr:	atom ((PROD|DIV|MOD) atom)*
	;
atom	:	LPAR expr RPAR
	|	INT
	|	FLOAT
	|	STRING
	|	IDENT
	|	IDENT LPAR listaExpr? RPAR
	;

leer	:	FUNCLEER LPAR STRING COMA AMPERSAND IDENT RPAR PUNTOYCOMA;	
imprimir:	FUNCIMPRIMIR LPAR STRING (COMA expr)* RPAR PUNTOYCOMA;

precompilacion 
	:	define
	|	include
	;

define	:	DEFINE IDENT atom; // Ej: #define PI 3.1415	
include	:	INCLUDE LIBRERIA
	;

