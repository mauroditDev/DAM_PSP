package ut2p2;

public class DentroFuera {

	public static void main(String[] args){
		try{
			HiloFor t1 = new HiloFor();
			Thread th = new Thread(t1);
			th.start();
			for(int i = 0; i< 100; i++)
				System.out.println("estoy fuera del hilo");
		}catch(Exception e){}
	}
	
}