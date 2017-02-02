package socketsUdp;

import java.net.*;
public class ServidorUDP{
	public static void main(String[] args) throws Exception {
			
			int puerto = 4567;
			byte[] bufer = new byte[1024];
			
			DatagramSocket socketUDP = new DatagramSocket(puerto);
			
			System.out.println("Esperando datagrama....");
			
			DatagramPacket recibido = new DatagramPacket (bufer, bufer.length);
			while(true){
				socketUDP.receive(recibido);
				String info = new String (recibido.getData());
				info = info.toUpperCase();
			//	System.out.println(info);
				recibido.setData(info.getBytes());
				socketUDP.send(recibido);
			}
			//socketUDP.close();
	}
}