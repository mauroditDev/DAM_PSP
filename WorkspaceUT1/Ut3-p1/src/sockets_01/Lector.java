package sockets_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

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
			while(clienteConectado.isConnected()){
				try{flujoSalida.writeUTF(flujoEntrada.readUTF());}
				catch(java.io.EOFException e){}
			}
			entrada.close();
			flujoEntrada.close();
			salida.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}