package ut2p8;

import java.util.concurrent.atomic.AtomicInteger;

public class Buscador implements Runnable {
	public int[] lista;
	private int posicion;
	private int sentido;
	public String nombre;
	private int posicionIn;
	private AtomicInteger ganador;
	public int id;
	
	public Buscador(AtomicInteger ganador, int id){
		posicion = (int) (Math.random() * 1000000);
		sentido = 1;
		this.ganador = ganador;
		this.id = id;
	}
	
	@Override
	public void run() {
		posicionIn = posicion;
		while(!buscar());
		System.out.println("encontrado por "+nombre+" en la posicion "+posicion);
	}
	
	public int getGanador(){
		return ganador.get();
	}
	
	public synchronized boolean buscar(){
		if(lista[posicion]==1){
			if(ganador.get()==0){
				ganador.set(id);
			}
			return true;
		}
		else{
			if(posicion<lista.length-1 && posicion>0){
				posicion+=sentido;
			}
			else{
				posicion = posicionIn;
				sentido = sentido * -1;
			}
		}
		return false;
	}
	
	public String toString(){
		if (id == ganador.get()){
			return "El ganador es el hilo: "+nombre;
		}
		else{
			return "";
		}
	}

}
