package ut2p3;

public class HiloSleep extends Thread{

	public int n;
	public HiloSleep(int n){
		super();
		this.n = n;
	}
	
	public void run(){
		try{
			Thread.sleep(2000);
			System.out.println("hiloC numero "+n);
		}catch(Exception e) {}
	}
	
}