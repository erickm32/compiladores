class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			System.out.println(codigo);
			System.out.println();

			al = new AnaliseLexica(args[0]);
			as = new Parser(al);
		
			arv = as.parseProg();

			CodeInterpreter interpreter = new CodeInterpreter();
			interpreter.interpret(arv);

		}catch(Exception e)
		{			
			e.printStackTrace();
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
