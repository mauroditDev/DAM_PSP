package ut1p4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ut1p4_2 {

public static void main(String[] args){
		
		Runtime runtime = Runtime.getRuntime();
		try{
			Process proceso = runtime.exec("iconv --huyh");
			InputStream is = proceso.getErrorStream();
			
			int exitVal;
			try{
				exitVal = proceso.waitFor();
				System.out.println("Valor de salida: "+exitVal);
			} catch(InterruptedException e) {
				e.toString();
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader (is));
			while(true){
				String a = br.readLine();
				if(a==null)
					break;
				else
					System.out.println(a);
			}
				
		}catch(Exception ex){
			
		}
		
	}
	
}
