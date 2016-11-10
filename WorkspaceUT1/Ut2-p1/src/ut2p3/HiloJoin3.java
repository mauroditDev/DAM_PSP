package ut2p3;

public class HiloJoin3 extends Thread{

	public int n;
	public HiloJoin3(int n){
		super();
		this.n = n;
	}
	
	@SuppressWarnings("deprecation")
	public void run(){
		System.out.println("hiloC numero "+n);
		for(int i=1; i<6; i++){
			System.out.println("hilo "+n+" linea "+i);
			if(i == n){
				this.stop();
			}
		}
	}
	
}
