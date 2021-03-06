package ut1p5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProgramaMultiproceso {
	
	public static void main(String[] args){
		
			Runtime runtime = Runtime.getRuntime();
			try{
				ProcessBuilder pb = new ProcessBuilder("ls","-la");
				Process proceso = pb.start();
				InputStream is = proceso.getInputStream();
				
				
				proceso.waitFor();
				
				Process proceso2 = runtime.exec("tr '[:alnum:]' 'd ");
				OutputStream os = proceso2.getOutputStream();
				
				BufferedReader br = new BufferedReader(new InputStreamReader (is));
				while(true){
					String a = br.readLine();
					if(a==null)
						break;
					else{
						a += "\n";
						os.write(a.getBytes());
					}
				}
				os.close();
				
				
				is = proceso2.getInputStream();
				br = new BufferedReader(new InputStreamReader (is));
				while(true){
					String a = br.readLine();
					System.out.println(a);
					if(a==null)
						break;
				}
					
			}catch(Exception ex){
				System.err.println(ex.toString());
			}
		
	}
		
}


