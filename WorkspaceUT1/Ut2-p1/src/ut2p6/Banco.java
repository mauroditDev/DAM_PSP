package ut2p6;

public class Banco {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta(1000);
		Cliente cli1 = new Cliente(cuenta,"cli1",55,0);
		Cliente cli2 = new Cliente(cuenta,"cli2",25,0);
		
		Thread th1 = new Thread(cli1);
		Thread th2 = new Thread(cli2);
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
			System.out.println(cuenta.getSaldo());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
