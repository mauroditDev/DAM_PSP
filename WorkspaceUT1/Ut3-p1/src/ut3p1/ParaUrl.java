package ut3p1;

import java.net.MalformedURLException;
import java.net.URL;

public class ParaUrl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("HTTPs",
					"informatica.lazarocardenas.es",
					"/pluginfile.php/3106/mod_resource/content/3/PSP_ut3_practica2.pdf");
			
			System.out.println("authority: "+url.getAuthority());
			System.out.println("default port: "+url.getDefaultPort());
			System.out.println("port: "+url.getPort());
			System.out.println("protocol: "+url.getProtocol());
			System.out.println("host: "+url.getHost());
			System.out.println("query: "+url.getQuery());
			System.out.println("path: "+url.getPath());
			System.out.println("file: "+url.getFile());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}