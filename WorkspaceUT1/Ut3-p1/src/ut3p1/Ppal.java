package ut3p1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ppal {

	public static void main(String[] args) {
		try {
			InetAddress[] res = InetAddress.getAllByName("google.es");
			for(InetAddress a: res){
				
				System.out.println("inet: " + a);
				System.out.println("direccion: " + a.getHostAddress());
				System.out.println("nombre: "+a.getHostName());
				System.out.println("canonical host name: "+a.getCanonicalHostName());
			}
			
			System.out.println("--------------------localhost------------------------");
			
			InetAddress a = InetAddress.getLocalHost();
			
				System.out.println("inet: " + a);
				System.out.println("direccion: " + a.getHostAddress());
				System.out.println("nombre: "+a.getHostName());
				System.out.println("canonical host name: "+a.getCanonicalHostName());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
