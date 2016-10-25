package ut2p2;

public class HiloCR implements Runnable{

	public int n;
	public HiloCR(int n){
		super();
		this.n = n;
	}
	
	public void run(){
		System.out.println("hiloC numero "+n);
	}
	
}
