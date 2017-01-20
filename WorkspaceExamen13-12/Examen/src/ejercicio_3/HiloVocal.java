package ejercicio_3;

public class HiloVocal implements Runnable{

	public String id;
	public int cant;
	public static String texto;
	public static int contador;
	
	@Override
	public void run() {
		cant = 0;
		buscar();
	}
	
	public synchronized void buscar(){
		while(texto.indexOf(id)!=-1){
			cant++;
			contador++;
			texto = texto.replaceFirst(id, "j");
		}
	}



	

}
