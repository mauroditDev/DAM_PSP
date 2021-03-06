package carrera;

public class Corredor implements Runnable {

	public double posicion;
	public String nombre;
	
	public Corredor(String n){
		posicion = 0;
		nombre = n;
	}
	
	@Override
	public void run() {
		correr(Math.random()*10);
		if(posicion > 100)
			System.out.println(nombre+" llego a la meta");
	}
	
	private void correr(double avance){
		posicion += avance;
		System.out.println(nombre+" lleva recorridos "+posicion+" metros");
	}

}
