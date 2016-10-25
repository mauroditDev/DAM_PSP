package ut2p2;

public class VariosHilos {

	public static void main(String[] args){
		int k = 0;
		HiloCR d1 = new HiloCR(++k);
		HiloCR d2 = new HiloCR(++k);
		HiloCR d3 = new HiloCR(++k);
		HiloCR d4 = new HiloCR(++k);
		HiloCR d5 = new HiloCR(++k);
		Thread c1 = new Thread(d1);
		Thread c2 = new Thread(d2);
		Thread c3 = new Thread(d3);
		Thread c4 = new Thread(d4);
		Thread c5 = new Thread(d5);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		
		System.out.println("Todos los hilos creados");
		
	}
	
}
