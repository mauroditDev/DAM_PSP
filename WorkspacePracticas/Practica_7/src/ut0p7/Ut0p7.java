package ut0p7;

import java.util.Scanner;

public class Ut0p7 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Archivador archivador = new Archivador();
		
		for(int i = 0; i<5;i++){
			String a1 = "nombre "+i;
			String a2 ="apellido "+i;
			Paciente a = new Paciente(a1,a2);
			archivador.guardar(a);
		}
		
		sc.close();
		
		archivador.listar();
		
		archivador.eliminar(3);
		
		archivador.listar();
		
		
		
		
	}
}
