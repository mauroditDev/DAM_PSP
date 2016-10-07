package practica9;

public class SinViajesException extends Exception {

	public SinViajesException(){
		super("No quedan viajes para realizar el trayecto!");
	}
	
	private static final long serialVersionUID = 1L;
	
}
