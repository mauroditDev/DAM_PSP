package ut1p4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ut1p4_3 {

public static void main(String[] args){
		
		Runtime runtime = Runtime.getRuntime();
		try{
			Process proceso = runtime.exec("passwd");
			
			
			OutputStream os = proceso.getOutputStream();
			os.write("nolose\n".getBytes());
			os.close();
			InputStream is = proceso.getErrorStream();
			InputStream is2 = proceso.getInputStream();
			
			int exitVal;
			try{
				exitVal = proceso.waitFor();
				System.out.println("Valor de salida: "+exitVal);
			} catch(InterruptedException e) {
				e.toString();
			}
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader (is2));
			while(true){
				String a = br2.readLine();
				if(a==null)
					break;
				else
					System.out.println(a);
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
			System.err.println(ex.getMessage());
		}
		
	}
	
}
