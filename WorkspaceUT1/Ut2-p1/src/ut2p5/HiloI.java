package ut2p5;

public class HiloI extends Thread {

	private Contador cont;

	public HiloI(String name,Contador c){
		cont = c;
		this.setName(name);
	}
	
	public Contador getCont() {
		return cont;
	}

	public void setCont(Contador cont) {
		this.cont = cont;
	}
	
	public void run(){
		for(int i=0;i<300;i++){
			//synchronized(cont){
				cont.decrementar();
			//}
			try{
				Thread.sleep(25);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println(cont.getC());
	}

}
