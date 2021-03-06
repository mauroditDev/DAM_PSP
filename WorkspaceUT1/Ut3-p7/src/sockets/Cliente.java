package sockets;

	import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Cliente {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		String host = "localhost";
		int nPuerto = 5000;
		Socket cliente = null;
		System.out.println("Iniciando el cliente....");
		cliente = new Socket (host, nPuerto);
		DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
		DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
		Scanner sc = new Scanner(System.in);
		/*String msg = "0";
		flujoSalida.writeUTF(msg);
		System.out.println(flujoEntrada.readUTF());
		msg = sc.nextLine();
		flujoSalida.writeUTF(msg);
		System.out.println(flujoEntrada.readUTF());
		*/
		//if(cliente.isConnected()){
			JSONObject objeto = new JSONObject();
			System.out.println("introduzca su nombre");
			objeto.put("nombre", sc.nextLine());
			System.out.println("introduzca su apellido");
			objeto.put("apellidos", sc.nextLine());
			System.out.println("introduzca su dni");
			objeto.put("DNI", sc.nextLine());
			System.out.println("introduzca su telefono");
			objeto.put("tel", sc.nextLine());
			System.out.println("introduzca su mail");
			objeto.put("mail", sc.nextLine());
			flujoSalida.writeUTF(objeto.toJSONString());
			System.out.println(flujoEntrada.readUTF());
		//}
		
		cliente.close();
		sc.close();
		flujoEntrada.close();
		flujoSalida.close();
		
	}

}
