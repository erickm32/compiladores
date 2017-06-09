import java.util.Stack;

class CodeInterpreter{
	int result = -1;

	int getResult(){
		return result;
	}

	void interpret(ArvoreSintatica arv){
		result = interpret2(arv);	
	}

	int interpret2(ArvoreSintatica arv){

		if (arv instanceof Mult){
			Exp op1, op2;
			op1	= ((Operador)arv).arg1;
			op2 = ((Operador)arv).arg2;
			return interpret2(op1) * interpret2(op2);
		}

		if (arv instanceof Soma){
			Exp op1, op2;
			op1	= ((Operador)arv).arg1;
			op2 = ((Operador)arv).arg2;
			return interpret2(op1) + interpret2(op2);
		}

		if (arv instanceof Subt){
			Exp op1, op2;
			op1	= ((Operador)arv).arg1;
			op2 = ((Operador)arv).arg2;
			return interpret2(op1) - interpret2(op2);
		}

		if (arv instanceof Div){
			Exp op1, op2;
			op1	= ((Operador)arv).arg1;
			op2 = ((Operador)arv).arg2;
			return interpret2(op1) / interpret2(op2);
		}

		if (arv instanceof Num){
			return ((Num) arv).num;
		}

		return -1;
	}
}
