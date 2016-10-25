package ut2p1;

public class VariosHilos {

	public static void main(String[] args){
		int k = 0;
		HiloC c1 = new HiloC(++k);
		HiloC c2 = new HiloC(++k);
		HiloC c3 = new HiloC(++k);
		HiloC c4 = new HiloC(++k);
		HiloC c5 = new HiloC(++k);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		
		System.out.println("Todos los hilos creados");
		
	}
	
}
