package ut0p7;

import java.util.Scanner;

public class Ut0p7 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Archivador archivador = new Archivador();
		
		for(int i = 0; i<5;i++){
			System.out.println("escribe nombre y apellido separado por un espacion");
			String aux = sc.next();
			String[] a = aux.split(" ");
			archivador.guardar(new Paciente(a[0],a[1]));
		}
		
		sc.close();
		
		archivador.listar();
		
		archivador.eliminar(3);
		
		archivador.listar();
		
		
		
		
	}
}