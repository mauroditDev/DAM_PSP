package ut2p9;

import java.util.concurrent.atomic.AtomicInteger;

public class Almacenero implements Runnable {
	
	public static AtomicInteger galletas;
	public int contador;
	public Monstruo primero;
	
	@Override
	public void run() {
			while(contador<10){
				synchronized(galletas){reponer();}
			}
	}
	
	public synchronized void reponer(){

		if(galletas.get()==0){
			System.out.println("el almacenero saca 10 galletas");
			contador++;
			galletas.set(10);
			System.out.println("total galletas "+ galletas.get());
		}
	}
	
	public Almacenero(){
		contador = 0;
	}

}
