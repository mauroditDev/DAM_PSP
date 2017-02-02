package serverMultipleConUdp;

import java.io.RandomAccessFile;
import java.net.*;
public class ServidorUDP{
	public static void main(String[] args) throws Exception {
			
			int puerto = 4567;
			byte[] bufer = new byte[1024];
			int cliente = 0;
			
			RandomAccessFile raf = new RandomAccessFile("./pass.data","rw");
			
			DatagramSocket socketUDP = new DatagramSocket(puerto);
			
			System.out.println("Esperando datagrama....");
			
			DatagramPacket recibido = new DatagramPacket (bufer, bufer.length);
			while(true){
				socketUDP.receive(recibido);
				String info = new String (recibido.getData());
				System.out.println(info);
				if(info.trim().equals("0")){
					System.out.println("info = 0");
					info = "bienvenido cliente nº"+cliente+"\npor favor, introduzca su nombre de usuario:";
					cliente++;
				}
				else{
					System.out.println("por queeeee?");
					String usuario = info;
					boolean encontrado = false;
					if(!encontrado){
						int passwd = (int)(Math.random()*10000);
						info = "La contraseña asignada al usuario "+usuario+" es: "+passwd;
						//raf.seek(raf.length());
						//raf.writeUTF(usuario+"||"+passwd+"\n");
						System.out.println(info);
					}
					else{
						
					}
				}
				recibido.setData(info.getBytes());
				socketUDP.send(recibido);
			}
			//socketUDP.close();
	}
}