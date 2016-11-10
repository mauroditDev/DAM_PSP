package ut2p1;

public class HiloReloj {
	public static void main(String[] args){
		try{
			for (int i = 0; i<100; i++){

				HiloTic tic = new HiloTic();
				HiloTac tac = new HiloTac();
				
				tic.start();
				synchronized(tic){
					tic.wait();
				}
				synchronized(tic){
					tic.notify();
				}
				
				tac.start();
				synchronized(tac){
					tac.wait();
				}
				synchronized(tac){
					tac.notify();
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
