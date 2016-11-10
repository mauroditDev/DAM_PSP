package ut2p3;

public class PruebaJoin2 {

	public static void main(String[] args){
		try{
			
			int k = 0;
			HiloJoin2 c[] = new HiloJoin2[6];
			
			while(k<6){
				c[k] = new HiloJoin2(k+1);
				c[k].start();
				Thread.sleep(40);
				k++;
			}
			Thread.sleep(250);
			System.out.println("Todos los hilos creados");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
