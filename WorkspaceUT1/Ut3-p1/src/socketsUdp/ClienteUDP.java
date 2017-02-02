package socketsUdp;

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
		String info = "";
		while(!info.equals("exit")){
			System.out.println("introduzca mensaje para el servidor");
			info = sc.nextLine();
			mensaje = info.getBytes();
			enviado.setData(mensaje);
			socketUDP.send(enviado);
			socketUDP.receive(enviado);
			System.out.println(new String (enviado.getData()));
		}
		socketUDP.close();
		
	}

}
