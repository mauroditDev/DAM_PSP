package ut2p9;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	
	public static void main(String[] args) {
		Almacenero.galletas = new AtomicInteger();
		Almacenero.galletas.set(10);
		System.out.println("hay 10 galletas");
		Almacenero almacenero = new Almacenero();
		Monstruo monstruo1 = new Monstruo((int)(Math.random()*9)+1);
		almacenero.primero = monstruo1;
		monstruo1.alm = almacenero;
		Monstruo monstruo2 = new Monstruo((int)(Math.random()*9)+1);
		monstruo2.alm = almacenero;
		Monstruo monstruo3 = new Monstruo((int)(Math.random()*9)+1);
		monstruo3.alm = almacenero;
		Thread t1 = new Thread(monstruo1);
		Thread t2 = new Thread(monstruo2);
		Thread t3 = new Thread(monstruo3);
		Thread t4 = new Thread(almacenero);
		t1.start();t2.start();t3.start();t4.start();
	}

}
