package ut2p1;

public class DentroFuera {

	public static void main(String[] args){
		try{
			HiloFor t1 = new HiloFor();
			t1.start();
			for(int i = 0; i< 10000; i++)
				System.out.println("estoy fuera del hilo");
		}catch(Exception e){}
	}
	
}
