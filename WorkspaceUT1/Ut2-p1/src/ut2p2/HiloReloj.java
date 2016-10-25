package ut2p2;

public class HiloReloj {
	public static void main(String[] args){
		try{
			HiloTicR tic = new HiloTicR();
			HiloTacR tac = new HiloTacR();
			for (int i = 0; i<100; i++){
				Thread t1 = new Thread(tic);
				Thread t2 = new Thread(tac);
				t1.start();
				Thread.sleep(1000);
				t2.start();
				Thread.sleep(1000);
			}
		}catch(Exception e){}
	}

}
