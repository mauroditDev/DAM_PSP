package ut1p6;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class EjecutarUT0 {
	public static void main(String[] args){
	
		long a = new Date().getTime();
		ProcessBuilder pb2 = new ProcessBuilder("tr","a","a");
		ProcessBuilder pb = new ProcessBuilder("java", "-jar",
				"/media/Datos/Datos_Mauro/PSP/jars/ut0p7.jar");
		try{
			Process proceso = pb.start();
			InputStream is = proceso.getInputStream();
			
			proceso.waitFor();
			
			
			Process proceso2 = pb2.start();
			OutputStream os = proceso2.getOutputStream();
			
			while(is.available()>0){
				os.write(is.read());
			}
			os.close();
			
			
			is = proceso2.getInputStream();
			
			proceso2.waitFor();
			
			while(is.available()>0){
				System.out.print((char)is.read());
			}
			
				
		}catch(Exception ex){
			System.err.println(ex.toString());
		}
		System.out.println(new Date().getTime()-a);
	}

}
