import java.util.Stack;

class CodeInterpreter{
	Stack<Integer> pilha;

	void interpret(ArvoreSintatica arv){
		pilha = new Stack<Integer>();
		interpret2(arv);
		System.out.println("14");
		while(!pilha.empty()){
			System.out.println(pilha.peek());
			interpret2(arv);
		}
		System.out.println(pilha.peek());
	}

	void interpret2(ArvoreSintatica arv){
		if (arv != null) System.out.println("arv não é null");

		if (arv instanceof Mult){
			int op1, op2;
			op1	= pilha.pop();
			op2 = pilha.pop();
			pilha.push(new Integer(op1 * op2));
		}

		if (arv instanceof Soma){
			int op1, op2;
			op1	= pilha.pop();
			op2 = pilha.pop();
			pilha.push(new Integer(op1 + op2));
		}

		if (arv instanceof Subt){
			int op1, op2;
			op1	= pilha.pop();
			op2 = pilha.pop();
			pilha.push(new Integer(op1 - op2));
		}

		if (arv instanceof Div){
			int op1, op2;
			op1	= arv.arg1;
			op2 = arv.arg2;
			pilha.push(new Integer((int)(op1 / op2)));
		}

		if (arv instanceof Num){
			System.out.println("passa aqui");
			pilha.push(new Integer(((Num) arv).num));
		}
		System.out.println("Vem pra ca");
	}
}
