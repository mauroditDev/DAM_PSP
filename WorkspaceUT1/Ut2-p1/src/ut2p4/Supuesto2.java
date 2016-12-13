package ut2p4;

import java.util.Scanner;

public class Supuesto2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("cuantas cajas quieres?");
		int cs = Integer.valueOf(sc.nextLine());
		CajaSimultanea[] cajas = new CajaSimultanea[cs];
		System.out.println("cuantos clientes tienes?");
		int cts = Integer.valueOf(sc.nextLine());
		Cliente[] clientes = new Cliente[cts];
		for( int i = 0; i<cts;i++){
			System.out.println("nombre del cliente "+(i+1));
			String nombre = sc.nextLine();
			System.out.println("cuantos productos lleva "+nombre+"?");
			int[] arr = new int[Integer.valueOf(sc.nextLine())];
			for(int j = 0; j<arr.length;j++){
				System.out.println("longitud del producto "+(j+1)+" de "+nombre);
				arr[j] = Integer.valueOf(sc.nextLine());
			}
			clientes[i] = new Cliente(nombre,arr);
		}
		for(int i = 0; i< cs; i++){
			cajas[i] = new CajaSimultanea();
			cajas[i].inicio=System.currentTimeMillis();
		}
		for(int i = 0, j=0;i<clientes.length;j++,i++){
			if(j==cajas.length)
				j=0;
			cajas[j].clientela.add(clientes[i]);
		}
		for(int i = 0; i< cs; i++){
			cajas[i].start();
		}
		sc.close();
	}

}
