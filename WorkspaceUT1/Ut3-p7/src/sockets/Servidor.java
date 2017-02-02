package sockets;

import java.net.*;
public class Servidor{
	public static int cliente = 0;
	public static void main(String[] args) throws Exception {
		int nPuerto = 5000;
		ServerSocket servidor = null;
		servidor = new ServerSocket (nPuerto,10);
		System.out.println("Esperando al cliente....");
		Aceptador ac = new Aceptador(servidor);
		Thread accepter = new Thread(ac);
		accepter.start();
	}
}