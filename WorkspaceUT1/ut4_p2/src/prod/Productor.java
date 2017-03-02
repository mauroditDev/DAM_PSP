package prod;
import java.util.List;

public class Productor implements Runnable {

	private List<String> productos;

	public Productor(List<String> productos) {
		this.productos = productos;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500);

				synchronized (productos) {

					productos.add("producto");
					productos.notify();
					System.out.println("Agregue un producto a la lista");
				}

			} catch (Exception ex) {
			}
		}
	}

}
