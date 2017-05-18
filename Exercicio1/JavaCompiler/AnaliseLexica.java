import java.io.*;

enum TokenType{ NUM,SOMA, SUBT, MULT, DIV, APar,FPar, EOF}

class Token{
  char lexema;
  String numero;
  TokenType token;

 Token (char l, TokenType t)
 	{ lexema=l;token = t;}	
 Token (String numero, TokenType t){
 	{ lexema = '\0'; this.numero = numero; token = t;}	
 }

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
								
	
				if (currchar >= '0' && currchar <= '9'){
					String numero = new String(currchar+"");
					currchar1 =  arquivo.read();
					currchar = (char) currchar1;
					while(currchar >= '0' && currchar <= '9'){
						currchar1 =  arquivo.read();
						currchar = (char) currchar1;
						numero+= currchar;
					}
					
					return (new Token (numero, TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							return (new Token (currchar,TokenType.APar));
						case ')':
							return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (currchar,TokenType.SOMA));
						case '-':
							return (new Token (currchar,TokenType.SUBT));
						case '*':
							return (new Token (currchar,TokenType.MULT));
						case '/':
							return (new Token (currchar,TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
		
	}
}
