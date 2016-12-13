package ut2p5;

public class CondicionCarrera {

	public static void main(String[] args) {
		Contador c = new Contador(100);
		HiloI i = new HiloI("inc",c);
		HiloD d = new HiloD("dec",c);
		
		i.start();
		d.start();

	}

}
