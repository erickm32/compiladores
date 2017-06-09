letra 						[a-zA-Z]
digito 						[0-9]
digitos 					{digito}+
facao_opcional 				(.{digitos})?
expoente_opcional 			(E(\+|-)?{digitos})?
letraoudigito 				{letra}|{digito}
finalsublinhado  			_{letraoudigito}+

identificador				{letra}+({letraoudigito})*({finalsublinhado})*
numero						{digitos}+({facao_opcional})*({expoente_opcional})*

palavra_reservada 			"void"|"int"|"bool"|"if"|"while"|"do"|"return"|"true"|"false"|"not"|"and"|"or"|"leq"|"skip"

%%

"{"	{ printf("abre_chave\n"); }
"}"	{ printf("fecha_chave\n"); }
"("	{ printf("abre_parentese\n"); }
")"	{ printf("fecha_parentes\n"); }
","	{ printf("virgula\n"); }
";"	{ printf("ponto_e_virgula\n"); }

":=" { printf("operador_atribuição\n"); }

"+"	{ printf("operador + \n"); }
"-"	{ printf("operador - \n"); }
"*"	{ printf("operador * \n"); }
"/"	{ printf("operador / \n"); }

{palavra_reservada}	{ printf("palavra_reservada: %s\n",yytext); } 

{identificador}	{ printf("identificador: %s\n",yytext); } 
{numero} { printf("numero: %s\n",yytext); } 

" "|"\n"|"\t" { 
				//printf("Pulando espaçamento.\n"); 
				}

. { printf("Símbolo %s não esperado.\n", yytext); }
%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}