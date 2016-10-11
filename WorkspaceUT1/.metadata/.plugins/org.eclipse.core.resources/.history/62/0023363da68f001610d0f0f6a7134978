package ut1p3;
import java.io.*;

public class Ut1p3 {
	public static void main(String[] args) {
	
		if (args.length <= 0) {
	
			System.err.println("Se necesita un programa a ejecutar");
	
			System.exit(-1);
		}
		
		Runtime runtime = Runtime.getRuntime();
		
		try {
			Process proceso	= runtime.exec(args);
			//TODO: meter un tiempo de espera para poder observar desde htop
			try{
				Thread.sleep(5000);
			}
			catch(Exception e){
				
			}
			proceso.destroy();
		}catch(IOException ex){
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}
		
	}
	
}
