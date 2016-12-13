package ut2p8;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] tabla = new int[1000000];
		int posicion = (int) ( Math.random() * 1000000 );
		AtomicInteger ganador = new AtomicInteger();
		
		for(int i=0;i<tabla.length;i++) {
			if(i==posicion)
				tabla[i]=1;
			else
				tabla[i]=0;
		}
		
		ganador.set(0);
		
		Buscador b1 = new Buscador(ganador,1);
		b1.nombre= "Bus1";
		b1.lista = tabla;
		Thread t1 = new Thread(b1);
		
		Buscador b2 = new Buscador(ganador,2);
		b2.nombre= "Bus2";
		b2.lista = tabla;
		Thread t2 = new Thread(b2);
		
		Buscador b3 = new Buscador(ganador,3);
		b3.nombre= "Bus3";
		b3.lista = tabla;
		Thread t3 = new Thread(b3);
		
		try{
			
			t1.start();
			t2.start();
			t3.start();
			
			Thread.sleep(100);
			System.out.println(b1.toString()+b2.toString()+b3.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	

}
