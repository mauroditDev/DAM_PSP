package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Lector implements Runnable{
	private Socket clienteConectado;
	private InputStream entrada;
	private DataInputStream flujoEntrada;
	private OutputStream salida;
	private DataOutputStream flujoSalida;
	
	public Lector(Socket s){
		clienteConectado = s;
	}
	
	@Override
	public void run() {
		try {
			entrada = clienteConectado.getInputStream(); 
			flujoEntrada = new DataInputStream (entrada);
			salida = clienteConectado.getOutputStream();
			flujoSalida = new DataOutputStream (salida);
			System.out.println("nuevo lector");
			while(clienteConectado.isConnected()){
				String mensaje = "";
				try{mensaje = flujoEntrada.readUTF();}catch(EOFException e){}
				
					System.out.println("mensaje: "+mensaje);
					JSONParser parser = new JSONParser();
					JSONObject recibido = (JSONObject)parser.parse(mensaje);
					
					String salida = "nombre: "+recibido.get("nombre");
					salida += "\napellidos: "+recibido.get("apellido");
					salida += "\nDNI: "+recibido.get("DNI");
					salida += "\ntelefono: "+recibido.get("tel");
					salida += "\nmail: "+recibido.get("mail");
					flujoSalida.writeUTF(salida);
					
					
			}
			entrada.close();
			flujoEntrada.close();
			salida.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

}