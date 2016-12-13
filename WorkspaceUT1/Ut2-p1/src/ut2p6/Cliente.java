package ut2p6;

public class Cliente implements Runnable{

	private Cuenta cuenta;
	private String nombre;
	private double cantidad;
	private double total;
	private int asd;
	
	public Cliente(Cuenta c, String n, double cant, double t){
		cuenta = c;
		nombre = n;
		cantidad = cant;
		total = t;
		asd = 0;
	}
	
	public synchronized boolean retirada(){
		if(cuenta.retirar(cantidad)){
			total += cantidad;
			asd++;
			return true;
		}
		else{
			return false;
		}
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public void run() {
			while(this.retirada()){
				try{
					//Thread.sleep(50);
				}catch(Exception e){e.printStackTrace();}
			}
			System.out.println(asd+"/"+cuenta.getReintegros()+": "+nombre+" = "+total);
	}
	
	
	
}
