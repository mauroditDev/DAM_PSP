package sensores;

public class Sensores {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		HiloControlador.lectura1 = new Float(-999f);
		
		
		HiloSensor sen1 = new HiloSensor();
		Thread t1 = new Thread(sen1);
		Thread t2 = new Thread(sen1);
		HiloControlador con = new HiloControlador();
		Thread t3 = new Thread(con);
		
		
		t1.start();
		t2.start();
		t3.start();
	}

}
