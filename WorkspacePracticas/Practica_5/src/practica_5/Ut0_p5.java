package practica_5;

import java.util.Scanner;

public class Ut0_p5 {

	public static void main(String args[]){
		int usuarios = 0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		Cuenta objCuenta = null;
		
		System.out.println("Cuantos titulares ingresará:");
		usuarios = Integer.parseInt(scan.next());
		
		for(int i = 0; i < usuarios; i++){
			Titular titular = new Titular();
			
			System.out.println("Nombre del titular " + (i+1) + ":");
			titular.setNombre(scan.next());
			
			System.out.println("Apellido del titular " + (i+1) + ":");
			titular.setApellidos(scan.next());
			
			System.out.println("Edad del titular " + (i+1) + ":");
			titular.setEdad(Integer.parseInt(scan.next()));
			
			String cuenta;
			System.out.println("Introduzca numero cuenta:");
			cuenta = scan.next();
			objCuenta = new Cuenta(titular,cuenta);
			System.out.println("Saldo inicial para la cuenta:");
			objCuenta.setSaldo(Double.parseDouble(scan.next()));
			System.out.println("Saldo minimo para la cuenta:");
			objCuenta.setSaldoMin(Double.parseDouble(scan.next()));
			
			
			boolean b_continuar = true;
			while(b_continuar){
				String s_operar = "";
				while(!s_operar.equals("ingresar") && !s_operar.equals("retirar") && !s_operar.equals("conteo")){
					System.out.println("Operacion a realizar (ingresar, retirar o conteo):");
					s_operar = scan.next();
				}
				
				double dato;
				switch(s_operar){
				case "ingresar":
					System.out.println("Cuantia a ingresar:");
					objCuenta.saldoSuma(Double.parseDouble(scan.next()));
					break;
				case "retirar":
					System.out.println("Cuantia a retirar:");
					dato = Double.parseDouble(scan.next());
					if(objCuenta.getSaldo()-dato < objCuenta.getSaldoMin())
						System.out.println("Demasiado elevada");
					else
						objCuenta.saldoResta(dato);
					break;
				case "conteo":
					System.out.println("Lleva ingresadas " + Cuenta.mostrarContador() + " Cuentas.");
					break;
				}
				
				System.out.println("otra operacion (si, no):");
				s_operar = scan.next();
				if(s_operar.equals("no")){
					b_continuar = false;
				}
				
			}
			
			
			System.out.println(objCuenta.toString());
			
			
		}
		
		
	}
	
}
