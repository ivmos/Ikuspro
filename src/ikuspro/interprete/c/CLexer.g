lexer grammar CLexer;

@header {
	package ikuspro.analizador.c;
}


TIPOBASE	:	l='void' //{ info("<void>"+ $l.line); }
	|	'char'
	| 	'int'
	|	'float'
	;
//tokens
INT	:	('0'..'9')+;
// Funciones predefinidas
FUNCLEER:	'scanf'
	;
FUNCIMPRIMIR
	:	'printf'
	;
IDENT	:	('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;
LCURL 	:	'{';
RCURL	:	'}';
LPAR	:	'(';
RPAR	:	')';
PUNTOYCOMA 
	:	';';
PUNTO	:	'.';
FLOAT	:	INT PUNTO INT;
AMPERSAND
	:	'&';
COMA	:	',';
//operaciones
PROD	:	'*';
DIV	:	'/';
MOD	:	'%';
MAS	:	'+';
MENOS	:	'-';
ASIG	:	'=';

//  White Space:
WS	:	(' '
	|	'\t'
	// Saltos de línea
	|	'\n'  
	|	'\r')+ 
		{skip();}
	;
	



// Comentarios de una línea
COMENTSIMPLE
	:	'//' 
		// Cualquier cosa es parte del comentario salvo saltos de línea etc..
		~('\n'|'\r')* '\r'? '\n'
		 {$channel=HIDDEN;}
	;
	
// Comentario multilínea
COMENTCOMP
	:	'/*' ( options {greedy=false;} : . )* 
		'*/' 
		{$channel=HIDDEN;}
    	;
    	

	
// Cosas de precompilación
STRING	: '"' ( ~'"' )* '"';
LIBRERIA 
	:	STRING
	|	'<' ( ~'>' )* '>';

DEFINE 	:	'#' 'define';

INCLUDE :	 '#' 'include';

	
