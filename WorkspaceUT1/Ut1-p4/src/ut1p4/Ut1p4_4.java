package ut1p4;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ut1p4_4 {
	public static void main(String[] args){
		
		Runtime runtime = Runtime.getRuntime();
		try{
			Process proceso = runtime.exec("cal 2015");
			InputStream is = proceso.getInputStream();
			
			int exitVal;
			try{
				exitVal = proceso.waitFor();
				System.out.println("Valor de salida: "+exitVal);
			} catch(InterruptedException e) {
				e.toString();
			}
			
			FileOutputStream fos = new FileOutputStream("salida.txt");
			PrintWriter pw = new PrintWriter(fos);
			
			BufferedReader br = new BufferedReader(new InputStreamReader (is));
			while(true){
				String a = br.readLine();
				if(a==null)
					break;
				else
					pw.println(a);
			}
			
			pw.close();
				
		}catch(Exception ex){
			
		}
		
	}
	
}
