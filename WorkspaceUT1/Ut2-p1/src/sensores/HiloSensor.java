package sensores;

public class HiloSensor implements Runnable{

	public float lect;
	@Override
	public void run() {
		//synchronized(HiloControlador.lectura1){
			while(HiloControlador.cont < 100){
				temperatura();
			}
		//}
	}

	public void temperatura(){
		synchronized(HiloControlador.lock){
			//synchronized(HiloControlador.orden){
				if(HiloControlador.orden == 1){
					lect = (float) (Math.random()*50);
			//		System.out.println("estoy en el sensor: "+HiloControlador.lectura1+", random: "+lect);
					if(HiloControlador.lectura1 == -999f || HiloControlador.lectura1 == -1f){
						HiloControlador.lectura1 = lect;
					}
			//		System.out.println("estoy en el sensor: "+HiloControlador.lectura1+", random: "+lect);
					HiloControlador.orden = 0;
				}
			//}
		}
	}
	

}
