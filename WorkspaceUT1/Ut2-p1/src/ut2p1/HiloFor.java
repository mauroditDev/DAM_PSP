package ut2p1;

public class HiloFor extends Thread{
	
	public void run(){
		for(int i = 0; i< 10000; i++)
			System.out.println("estoy dentro del hilo");
	}

}
