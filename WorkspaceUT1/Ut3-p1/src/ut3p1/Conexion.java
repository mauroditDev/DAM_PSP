package ut3p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conexion {

	public static void main(String[] args) {
		try {
			URL url = new URL("HTTP",
					"google.es",
					"/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String linea = br.readLine();
			while(linea!=null){
				System.out.println(linea);
				linea = br.readLine();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
