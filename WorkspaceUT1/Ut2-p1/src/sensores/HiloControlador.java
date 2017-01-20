package sensores;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HiloControlador implements Runnable{

	static public Float lectura1;
	static public Integer cont = 0;
	static public Integer orden = 1;
	static public Lock lock = new ReentrantLock();
	public float humedad;
	public float temperatura;
	public int sw;

	@Override
	public void run() {
		synchronized(lectura1){
			while(cont < 100){
				lectura();
			}
		}
		
	}
	
	public void lectura(){
		synchronized(HiloControlador.lock){
			synchronized(orden){
				if(orden == 0){
					if(lectura1 != -999f && lectura1 != -1){
						if(sw==0){
							humedad = lectura1;
							sw = 1;
							lectura1 = -999f;
						}
						else{
							if(sw==1){
							temperatura = lectura1;
							sw = 2;
							lectura1 = -1f;
							}
							else{
								sw = 0;
								if(temperatura > 25 && humedad > 40)
									System.out.println("HACE CALOR ("+temperatura+", "+humedad+")");
								else
									System.out.println("HACE FRIO ("+temperatura+", "+humedad+")");
								temperatura = -1;
								humedad = -1;
								lectura1 = -999f;
								cont++;
							}
						}
						orden = 1;
					}
				}
			}
		}
	}

}
