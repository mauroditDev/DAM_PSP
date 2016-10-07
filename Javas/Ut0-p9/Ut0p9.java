package practica9;

import java.util.Scanner;

public class Ut0p9 {

	public static void main(String[] args) {
		BonoMetro bm = new BonoMetro();
		bm.setViajesRestantes(10);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("tienes "+bm.getViajesRestantes()+" viajes!");
		
		while(true){
			try{
				sc.next();
				bm.viajar();
				System.out.println("has viajado!");
				System.out.println("te quedan "+bm.getViajesRestantes()+" viajes");
				
			}catch(Exception e){
				System.err.println(e.getMessage());
				break;
			}
		}
		sc.close();
		

	}

	
	
}
