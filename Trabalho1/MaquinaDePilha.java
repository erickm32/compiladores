import java.io.*;
import java.util.Stack;

class MaquinaDePilha {

	public static void main(String[] args) {
		BufferedReader arquivo;
		try {
		 	arquivo = new BufferedReader(new FileReader(args[0]));

		 	Stack<Integer> pilha = new Stack<>();
		 	int op1, op2;

		 	String linha = arquivo.readLine();
		 	while(linha != null){

		 		String[] splitted = linha.split(" ");
		 		String first = splitted[0];
		 		if(first.equalsIgnoreCase("PUSH")){
		 			pilha.push(new Integer(splitted[1]));
		 		}
		 		else if (first.equalsIgnoreCase("ADD")) {
		 			op2 = pilha.pop().intValue();
		 			op1 = pilha.pop().intValue();
		 			pilha.push(new Integer(op1 + op2));
		 		}
		 		else if (first.equalsIgnoreCase("SUBT")) {
		 			op2 = pilha.pop().intValue();
		 			op1 = pilha.pop().intValue();
		 			pilha.push(new Integer(op1 - op2));
		 		}
		 		else if (first.equalsIgnoreCase("MULT")) {
		 			op2 = pilha.pop().intValue();
		 			op1 = pilha.pop().intValue();
		 			pilha.push(new Integer(op1 * op2));
		 		}
		 		else if (first.equalsIgnoreCase("DIV")) {
		 			op2 = pilha.pop().intValue();
		 			op1 = pilha.pop().intValue();
		 			pilha.push(new Integer(op1 / op2));
		 		}
		 		else if (first.equalsIgnoreCase("PRINT")) {
		 			System.out.println(pilha.peek().intValue());
		 		}
		 		else {
		 			System.out.println("erro: '" + linha + "'");
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
