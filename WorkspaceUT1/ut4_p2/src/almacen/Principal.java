package almacen;

public class Principal {


	public static void main(String[] args) {

		Almacen almacen=new Almacen();
		
		Monstruo m1=new Monstruo(1,almacen);
		Monstruo m2=new Monstruo(2,almacen);
		Monstruo m3=new Monstruo(3,almacen);
		
		Almacenero a=new Almacenero(almacen);
		
		m1.start();
		m2.start();
		m3.start();
		
		a.start();
		
		
		
		
	}

}
