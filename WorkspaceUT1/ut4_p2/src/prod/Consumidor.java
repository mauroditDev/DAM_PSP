package prod;
import java.util.List;

public class Consumidor implements Runnable {

	private List<String> productos;

	public Consumidor(List<String> productos) {
		this.productos = productos;
	}
	
	public void run(){
		try{
			synchronized(productos){
				if(productos.size()==0){
					System.out.println("No hay productos loco, me quedo aca hasta que me vendas");
					productos.wait();
				}
				
				productos.remove(0);
				System.out.println("Consumiiii!!");
				
				
			}
		}catch(Exception ex){}
	}

}

