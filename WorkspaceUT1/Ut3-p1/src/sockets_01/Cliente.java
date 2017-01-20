package sockets_01;

	import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws Exception {
		
		String host = "172.26.105.83";
		int nPuerto = 5000;
		Socket cliente = null;
		System.out.println("Iniciando el cliente....");
		cliente = new Socket (host, nPuerto);
		DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
		DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
		Scanner sc = new Scanner(System.in);
		String msg = "";
		while(!msg.equals("exit")){
			System.out.println("peticion al server?");
			msg = sc.nextLine();
			flujoSalida.writeUTF(msg);
			System.out.println(flujoEntrada.readUTF());
		}
		System.out.println("Desconectando del SERVIDOR....");
		
		
		sc.close();
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
	}

}