package ut2p3;

public class PruebaSleep2 {

	public static void main(String[] args){
		try{
		int k = 0;
		while(k<11){
			HiloSleep c = new HiloSleep(k++);
			c.start();
			Thread.sleep(2000);
		}
		
		System.out.println("Todos los hilos creados");
		}catch(Exception e){}
	}
	
}
