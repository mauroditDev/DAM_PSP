package ut2p3;

public class HiloJoin extends Thread{

	public int n;
	public HiloJoin(int n){
		super();
		this.n = n;
	}
	
	public void run(){
		System.out.println("hiloC numero "+n);
		for(int i=1; i<6; i++){
			System.out.println("hilo "+n+" linea "+i);
		}
	}
	
}
