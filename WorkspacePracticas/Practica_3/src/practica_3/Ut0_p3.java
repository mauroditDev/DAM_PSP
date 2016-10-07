package practica_3;

import java.util.Scanner;

public class Ut0_p3 {

	public static void main(String args[]){
		int usuarios = 0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		CuentaCorriente objCuenta = null;
		
		System.out.println("Cuantos titulares ingresará:");
		usuarios = Integer.parseInt(scan.next());
		
		for(int i = 0; i < usuarios; i++){
			Titular titular = new Titular();
			
			System.out.println("Nombre del titular " + i+1 + ":");
			titular.setNombre(scan.next());
			
			System.out.println("Apellido del titular " + i+1 + ":");
			titular.setApellidos(scan.next());
			
			System.out.println("Edad del titular " + (i+1) + ":");
			titular.setEdad(Integer.parseInt(scan.next()));
			
			String orden = "";
			
			while( !orden.equals("Corriente") && !orden.equals("Ahorros")){
				System.out.println("Corriente o Ahorros");
				orden = scan.next();
			}
			
			if(orden == "Corriente"){
				
				String cuenta;
				System.out.println("Introduzca numero cuenta:");
				cuenta = scan.next();
				objCuenta = new CuentaCorriente(titular,cuenta);
				System.out.println(objCuenta.toString());
				
			}
			
			else{
				
				String cuenta;
				System.out.println("Introduzca numero cuenta:");
				cuenta = scan.next();
				double saldo;
				System.out.println("Introduzca saldo:");
				saldo = Double.parseDouble(scan.next());
				double interes;
				System.out.println("Introduzca interes:");
				interes = Double.parseDouble(scan.next());
				
				objCuenta = new CuentaAhorro(titular,cuenta,interes);
				objCuenta.setSaldo(saldo);
				
				System.out.println(objCuenta.toString());
				((CuentaAhorro)objCuenta).calcularInteres();
				System.out.println("Saldo tras aplicar interes: " + objCuenta.getSaldo());
				
			}
			
		}
		
		
	}
	
}
