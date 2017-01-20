package ejercicio_3;

import java.util.Scanner;

public class Ejercicio_3 {
	

	
	public static void main(String[] args){
		HiloVocal.contador = 0;
		HiloVocal a = new HiloVocal();
		a.id = "a";
		HiloVocal e = new HiloVocal();
		e.id = "e";
		HiloVocal i = new HiloVocal();
		i.id = "i";
		HiloVocal o = new HiloVocal();
		o.id = "o";
		HiloVocal u = new HiloVocal();
		u.id = "u";
		
		System.out.println("Introduzca texto para buscar vocales:");
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine();
		HiloVocal.texto = texto.toLowerCase();
		sc.close();
		
		Thread tha = new Thread(a);
		tha.start();
		Thread the = new Thread(e);
		the.start();
		Thread thi = new Thread(i);
		thi.start();
		Thread tho = new Thread(o);
		tho.start();
		Thread thu = new Thread(u);
		thu.start();
		
		try{
			Thread.sleep(200);
			
			System.out.println("Resultado:");
			System.out.println("A: "+a.cant);
			System.out.println("E: "+e.cant);
			System.out.println("I: "+i.cant);
			System.out.println("O: "+o.cant);
			System.out.println("U: "+u.cant);
			System.out.println("Total: "+HiloVocal.contador);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	

}
