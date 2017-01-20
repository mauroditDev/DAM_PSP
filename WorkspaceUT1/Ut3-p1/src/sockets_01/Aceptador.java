package sockets_01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Aceptador implements Runnable{
	public ServerSocket servidor;
	public ArrayList<Socket> clientes;
	
	public Aceptador(ServerSocket s){
		servidor = s;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Lector re = new Lector(servidor.accept());
				Thread reader = new Thread(re);
				reader.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
