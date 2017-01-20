package ejercicio_1;

public class HiloEj1 implements Runnable{
	
	public int resultado;
	
	public void run(){
		resultado = (int)(Math.random() * 6);
	}

}
