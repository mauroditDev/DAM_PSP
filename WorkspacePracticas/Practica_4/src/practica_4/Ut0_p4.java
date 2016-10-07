package practica_4;

import java.util.Scanner;

public class Ut0_p4 {

	public static void main(String[] args) {

		Poligono objeto = null;
		
		int cont = 0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Cuantos poligonos ingresará:");
		cont = Integer.parseInt(scan.next());
		
		for(int i = 0; i < cont; i++){
		
			String tipo = "";
			
			while(!tipo.equals("Cuadrado") && !tipo.equals("Rectangulo") && !tipo.equals("Triangulo")){
				System.out.println("Que tipo de poligono (Cuadrado, Rectangulo o Triangulo)");
				tipo = scan.next();
			}
			
			double dato;
			
			switch(tipo){
			
			case "Cuadrado":
				objeto = new Cuadrado();
				System.out.println("Lado del Cuadrado:");
				dato = Double.parseDouble(scan.next());
				((Cuadrado)objeto).setLado(dato);
				System.out.println(objeto.toString());
				break;
			case "Triangulo":
				objeto = new Triangulo();
				System.out.println("Base del Triangulo:");
				dato = Double.parseDouble(scan.next());
				((Triangulo)objeto).setBase(dato);
				System.out.println("Altura del Triangulo:");
				dato = Double.parseDouble(scan.next());
				((Triangulo)objeto).setAltura(dato);
				System.out.println(objeto.toString());
				break;
			case "Rectangulo":
				objeto = new Rectangulo();
				System.out.println("Base del Rectangulo:");
				dato = Double.parseDouble(scan.next());
				((Rectangulo)objeto).setBase(dato);
				System.out.println("Altura del Rectangulo:");
				dato = Double.parseDouble(scan.next());
				((Rectangulo)objeto).setAltura(dato);
				System.out.println(objeto.toString());
				break;
				
			}
		
		}
		

	}

}
