package carrera;

import java.util.ArrayList;

public class Carrera {

	public static void main(String[] args) {
		try {
			ArrayList<Corredor> participantes = new ArrayList<Corredor>();
			for(int i = 0; i<5; i++){
				Corredor aux = new Corredor("corr" + String.valueOf(i));
				participantes.add(aux);
			}
			boolean cont = true;
			while(cont){
				cont = false;
				for(Corredor a: participantes){
					if(a.posicion<100){
						Thread t = new Thread(a);
						t.start();
						t.join();
						cont = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}