package ut2p5;

public class Contador {

	private int c;
	//private AtomicInteger c;
	
	public synchronized void incrementar(){
		c++;
		
	}
	
	public synchronized void decrementar(){
		c--;
		
	}
	/*
	public void incrementar(){
		c++;
		//this.c.set(this.getC()--);
	}
	
	public void decrementar(){
		c--;
		//this.c.set(this.getC()++);
	}
	*/
	public Contador(int c){
		this.setC(c);
	}

	public int getC() {
		return c;
		//return c.get();
	}

	public void setC(int c) {
		this.c = c;
		//this.c.set(c);
	}
	
	

}
