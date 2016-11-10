package ut2p3;

public class HiloSleep2 extends Thread{

	public int n;
	public HiloSleep2(int n){
		super();
		this.n = n;
	}
	
	public void run(){
		try{
			System.out.println("hiloC numero "+n);
		}catch(Exception e) {}
	}
	
}
