package ut2p9;

public class Monstruo implements Runnable{

	private int cantidad;
	public Almacenero alm;
	
	@Override
	public void run() {	
		while(alm.contador<=10){
			synchronized(Almacenero.galletas){
				comer();
			}
		}
	}
	
	public synchronized void comer(){
		if(Almacenero.galletas.get() >0){
			String print = "un monstruo come "+String.valueOf(cantidad)+" galletas";
			Almacenero.galletas.set(Almacenero.galletas.get()-cantidad);
			if(Almacenero.galletas.get()<0){
				print = "un monstruo come "+String.valueOf(cantidad+Almacenero.galletas.get())+" galletas";
				Almacenero.galletas.set(0);
				
			}
			System.out.println(print);
			System.out.println("total galletas: "+Almacenero.galletas);
		}
	}
	
	public Monstruo(int cantidad){
		this.cantidad = cantidad;
	}

}
