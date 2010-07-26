grammar sd;



@members {

	public void echo(String pCadena) {
		System.out.println(pCadena + ";\n");
	}

}

tokens {
	PROGRAMA; DECLARACIONES; SENTENCIAS; DECLARACION;
	 ENVIO; DESTRUIR; DEFAULT; RETURN;
	
	
}


// Analizador sintactico
programa:	declaraciones sentencias EOF
	->	^(PROGRAMA ^(DECLARACIONES declaraciones) ^(SENTENCIAS sentencias))
	;
declaraciones
	:	declaracion+ 
	;

declaracion
	:	STRING AS ID NEWLINE
	{	echo("object(" + $ID.value + "," + $STRING.value + ")"); }
	; 
		
sentencias
	:	sentencia+
	;

sentencia
	:	activacion
	|	desactivacion
	|	envio
	|	retorno
	|	muere
	;

activacion
	:	ON ID NEWLINE
	{	echo("activate " + $ID.value); }
	;
desactivacion
	:	OFF ID NEWLINE
	{	echo("deactivate " + $ID.value); }
	;

envio	:	a=ID '->' b=ID ':' STRING  NEWLINE
	{	echo("message(" + $a.value + "," + $b.value + "," + $STRING.value); }
	;

retorno :	a=ID '-->' b=ID ':' STRING NEWLINE
	{	echo("return_message(" + $a.value + "," + $b.value + "," + $STRNG.value); }
	;

muere	:	'die' ID NEWLINE
	{	echo("delete(" . $ID.value . ")"); }
	;


// Analizador lexico

AS
	:	'as'
	;

ON
	:	'on'
	;

OFF
	:	'off'
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

FIN_SENTENCIA
	:	';'
	;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        ) {$channel=HIDDEN;}
    ;
   
NEWLINE	:	'\r'? '\n';

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

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

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;


