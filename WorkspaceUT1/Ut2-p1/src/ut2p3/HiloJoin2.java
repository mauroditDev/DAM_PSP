package ut2p3;

public class HiloJoin2 extends Thread{

	public int n;
	public HiloJoin2(int n){
		super();
		this.n = n;
	}
	
	public void run(){
		try{
			System.out.println("hiloC numero "+n);
			
			Thread.sleep(250);
			
			for(int i=1; i<6; i++){
				System.out.println("hilo "+n+" linea "+i);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
