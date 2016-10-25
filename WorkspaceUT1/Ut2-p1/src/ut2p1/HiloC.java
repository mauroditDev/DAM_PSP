package ut2p1;

public class HiloC extends Thread{

	public int n;
	public HiloC(int n){
		super();
		this.n = n;
	}
	
	public void run(){
		System.out.println("hiloC numero "+n);
	}
	
}
