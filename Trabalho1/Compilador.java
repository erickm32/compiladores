import java.io.*;

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
			//System.out.println(codigo);

			BufferedWriter writer = null;
        	try {
	            File instrucoesGeradas = new File(args[1]);

	            writer = new BufferedWriter(new FileWriter(instrucoesGeradas));
	            writer.write(codigo);
	        } catch (Exception e) {
				e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }

		} catch(Exception e) {			
			e.printStackTrace();
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
