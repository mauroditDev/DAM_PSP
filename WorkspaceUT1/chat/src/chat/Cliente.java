package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Runnable, Observer{
	private Socket socket; 
    private ChatMsg chatMsg;
    private DataInputStream dis;
    private DataOutputStream dos;
	
	public Cliente(Socket sock, ChatMsg chatMsg){
		this.socket = sock;
		this.chatMsg = chatMsg;
		try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            System.out.println(
            		"Error al crear los stream de entrada y salida : " + 
            				ex.getMessage()
            		);
        }
	}

	@Override
	public void run() {
		 String mensajeRecibido;
	        boolean conectado = true;
	        chatMsg.addObserver(this);
	        
	        while (conectado) {
	            try {
	                // Lee un mensaje enviado por el cliente
	                mensajeRecibido = dis.readUTF();
	                // Pone el mensaje recibido en mensajes para que se notifique 
	                // a sus observadores que hay un nuevo mensaje.
	                chatMsg.setMensaje(mensajeRecibido);
	            } catch (IOException ex) {
	                System.out.println(
	                		"Cliente con la IP " +
            				socket.getInetAddress().getHostName() +
            				" desconectado."
            				);
	                conectado = false; 
	                // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
	                try {
	                    dis.close();
	                    dos.close();
	                } catch (Exception ex2) {
	                    System.out.println(
	                    		"Error al cerrar los stream de entrada y salida :"
	                    		+ ex2.getMessage()
	                    		);
	                }
	            } catch(Exception ex3){
	            	ex3.printStackTrace();
	            }
	        }   
		
	}

	@Override
	public void update(Observable o, Object arg) {
		 try {
	            // Envia el mensaje al cliente
	            dos.writeUTF(arg.toString());
	        } catch (IOException ex) {
	            System.out.println(
	            		"Error al enviar mensaje al cliente ("
	            		+ ex.getMessage() + ")."
	            		);
	        }
		
	}
	
	
	
}
