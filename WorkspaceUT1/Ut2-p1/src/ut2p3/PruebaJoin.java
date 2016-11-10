package ut2p3;

public class PruebaJoin {

	public static void main(String[] args){
		try{
			int k = 0;
			HiloJoin c[] = new HiloJoin[6];
			while(k<6){
				c[k] = new HiloJoin(k+1);
				c[k].start();
				c[k].join();
				k++;
			}
			
			System.out.println("Todos los hilos creados");
		}catch(Exception e){}
	}
	
}
