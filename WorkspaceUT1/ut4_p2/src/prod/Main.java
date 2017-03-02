package prod;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args){
		List<String> productos = new ArrayList<String>();
		Productor p = new Productor(productos);
		Consumidor c = new Consumidor(productos);
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(p);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
