package sockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

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
				if(mensaje.trim().equals("0")){
					try{
						flujoSalida.writeUTF("Bienvenido cliente n."+Servidor.cliente+"\n" +
							"por favor introduzca su nombre de usuario:");
						Servidor.cliente++;
					}
					catch(java.io.EOFException e){}
				}
				else{
					ArrayList<String> users = new ArrayList<String>();
					ArrayList<String> pass = new ArrayList<String>();
					String currentUser = mensaje;
					try{
						BufferedReader br = new BufferedReader(new FileReader("./pass.data"));
						String linea = br.readLine();
						while(linea!=null){
							users.add(linea.split(":")[0]);
							pass.add(linea.split(":")[1]);
							System.out.println(linea);
							linea = br.readLine();
						}
						br.close();
					}
					catch(FileNotFoundException e){}
					int i = 0; int currentPass = -1;
					for(String user : users){
						if(user.equals(currentUser)){
							currentPass = Integer.parseInt(pass.get(i));
						}
						System.out.println("usuario: "+user);
						i++;
					}
					
					if(currentPass == -1 && !currentUser.equals("")){
						System.out.println("nuevo usuario");
						try{
							int passwd = (int)(Math.random()*10000);
							flujoSalida.writeUTF("La contraseña asignada al usuario "+currentUser+" es: "+passwd);
							clienteConectado.close();
							System.out.println("deberia escribir: "+currentUser+":"+passwd+"\n");
							PrintWriter pw = new PrintWriter(new FileWriter("./pass.data",true));
							pw.write(currentUser+":"+passwd+"\n");
							pw.close();
						}
						catch(java.io.EOFException e){}
					}
					else{
						System.out.println("viejo usuario");
						flujoSalida.writeUTF("La contraseña del usuario "+currentUser+" es: "+currentPass);
					}
				}
				
			}
			entrada.close();
			flujoEntrada.close();
			salida.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

}