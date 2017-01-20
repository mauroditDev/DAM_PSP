package ejercicio_2;

import java.io.InputStreamReader;
import java.io.OutputStream;



public class Ejercicio_2 {
	public static void main(String[] args){
		if(args.length != 2){
			System.out.println("deben pasarse dos argumentos");
		}
		else{
			
			try {
				Runtime runtime = Runtime.getRuntime();
				Process proceso1 = runtime.exec(args[0]);
				//Process proceso1 = runtime.exec("ls -al");
				
				proceso1.waitFor();
				
				InputStreamReader isr = new InputStreamReader(proceso1.getInputStream());
				Process proceso2;
				proceso2= runtime.exec(args[1]);
				//proceso2= runtime.exec("wc -l");
				OutputStream os= proceso2.getOutputStream();
				
				while(true){
					byte a = (byte)isr.read();
					if(a==-1)
						break;
					else{
						char aux = (char) a;
						os.write(a);
						//System.out.print(aux);
					}
				}
				isr.close();
				os.close();
				InputStreamReader isr2 = new InputStreamReader(proceso2.getInputStream());
				while(true){
					byte a = (byte)isr2.read();
					if(a==-1)
						break;
					else{
						char aux = (char)a;
						System.out.print(aux);
					}
				}
				isr2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
