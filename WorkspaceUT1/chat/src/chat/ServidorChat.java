package chat;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {
	public static void main(String[] args){
		
        ServerSocket servidor = null; 
        Socket socket = null;
        ChatMsg mensajes = new ChatMsg();
        
        try {
            servidor = new ServerSocket(1555, 10);

            while (true) {
                System.out.println("Servidor a la espera de conexiones.");
                socket = servidor.accept();
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
                
                Cliente cc = new Cliente(socket, mensajes);
                Thread ct = new Thread(cc);
                ct.start();
                
            }
        } catch (Exception ex) {
        	System.out.println("Error: " + ex.getMessage());
        } finally{
            try {
                socket.close();
                servidor.close();
            } catch (Exception ex) {
            	System.out.println("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
}