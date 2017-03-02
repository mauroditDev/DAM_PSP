package almacen;

public class Almacenero extends Thread {

	Almacen m;

	public Almacenero(Almacen m) {
		this.m = m;
	}

	public void run() {

		while (m.activo) {
			synchronized (m) {
				
				if (m.galletas == 0 && m.activo) {
					m.galletas = 10;
					m.contador++;
					m.notify();
					System.out.println("El almacenero ha repuesto galletas.");
					
				}
				
				if (m.contador==10) {
					m.activo = false;
					System.out.println("Se acabaron las galletas.");
				}
				
			}
		}
	}
}
