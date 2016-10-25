package ut2p2;

public class HiloFor implements Runnable{
	
	public void run(){
		for(int i = 0; i< 10000; i++)
			System.out.println("estoy dentro del hilo");
	}

}
