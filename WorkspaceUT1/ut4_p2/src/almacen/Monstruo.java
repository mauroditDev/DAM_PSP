package almacen;

public class Monstruo extends Thread {

	Almacen m;
	int id;
	int robo;

	public Monstruo(int id, Almacen m) {
		this.id = id;
		this.m = m;
	}

	public void run() {

		while (m.activo) {
			synchronized (m) {
				if (m.galletas > 0) {
					robo = (int) (Math.random() * 10) + 1;
					if (m.galletas > robo) {
						m.galletas -= robo;
					} else {
						robo = m.galletas;
						m.galletas = 0;
					}
					m.total += robo;
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("El Monstruo " + id + " ha robado "
							+ robo + " galleta/s. Total="+m.total);
				}
				try {
					m.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
