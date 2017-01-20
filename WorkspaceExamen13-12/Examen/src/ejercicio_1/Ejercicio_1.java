package ejercicio_1;

public class Ejercicio_1 {

	public static void main(String[] args){
		HiloEj1 h1 = new HiloEj1();
		HiloEj1 h2 = new HiloEj1();
		Thread th1 = new Thread(h1);
		Thread th2 = new Thread(h2);
		th1.start();
		th2.start();
		try {
			th2.join();
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(h1.resultado>h2.resultado)
			System.out.println("ha ganado el hilo 1 con un: "+h1.resultado+
					" contra un: "+h2.resultado);
		else{
			if(h1.resultado==h2.resultado)
				System.out.println("Empate con un: "+h1.resultado+
						" contra un: "+h2.resultado);
			else
				System.out.println("ha ganado el hilo 2 con un: "+h2.resultado+
						" contra un: "+h1.resultado);
		}
	}
	
}
