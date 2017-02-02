package serverMultipleConUdp;

import java.net.*;
import java.util.Scanner;

public class ClienteUDP {
	
	public static void main(String[] args) throws Exception {
		

		int puerto = 4567;
		InetAddress destino = InetAddress.getLocalHost();
		byte[] mensaje = new byte[1024];
		Scanner sc = new Scanner(System.in);
		DatagramPacket enviado = new DatagramPacket (mensaje, mensaje.length, destino, puerto);
		DatagramSocket socketUDP = new DatagramSocket();
		
		String info = "0                                    " +
				"                                    "+
				"                                    ";
		mensaje = info.getBytes();
		enviado.setData(mensaje);
		socketUDP.send(enviado);
		System.out.println("esperando respuesta...");
		socketUDP.receive(enviado);
		String resp = new String (enviado.getData());
		System.out.println(resp);
			
		info = sc.nextLine();
		mensaje = info.getBytes();
		enviado.setData(mensaje);
		socketUDP.send(enviado);
		socketUDP.receive(enviado);
		System.out.println(new String (enviado.getData()));
			
		socketUDP.close();
		
	}

}
