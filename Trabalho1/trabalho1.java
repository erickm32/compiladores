import java.io.*;
import java.util.Stack;

class Trabalho {

	public static void main(String[] args) {
		BufferedReader arquivo;
		try {
		 	arquivo = new BufferedReader(new FileReader(args[0]));

		 	Stack<Integer> pilha = new Stack();

		 	String linha = arquivo.readLine();
		 	while(linha != null){

		 		String[] splitted = linha.split(" ");
		 		String first = splitted[0];
		 		if(first.equalsIgnoreCase("PUSH")){
		 			pilha.push(new Integer(splitted[1]));
		 		}
		 		else if (first.equalsIgnoreCase("ADD")) {
		 			pilha.push(new Integer(pilha.pop() + pilha.pop()));
		 		}
		 		else if (first.equalsIgnoreCase("SUBT")) {
		 			pilha.push(new Integer(pilha.pop() - pilha.pop()));
		 		}
		 		else if (first.equalsIgnoreCase("MULT")) {
		 			pilha.push(new Integer(pilha.pop() * pilha.pop()));
		 		}
		 		else if (first.equalsIgnoreCase("DIV")) {
		 			pilha.push(new Integer(pilha.pop() * pilha.pop()));
		 		}
		 		else if (first.equalsIgnoreCase("PRINT")) {
		 			System.out.println(pilha.peek());
		 		}
		 		else if (first == "\n"){
		 			System.out.println("\\n.");
		 		}
		 		else {
		 			System.out.println("erro: '" + first + "'");
		 		}

		 		linha = arquivo.readLine();
		 	}
		}
		catch (Exception e) {
			System.out.println("Algo de errado não está certo: ");
			e.printStackTrace();
		}		
	}
}
