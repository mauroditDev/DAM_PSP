package practica_5;

public class CuentaAhorro extends Cuenta{

	
	
	public CuentaAhorro(Titular titular, String numeroCuenta) {
		super(titular, numeroCuenta);
		this.setInteres(2.25);
	}
	
	public CuentaAhorro(Titular titular, String numeroCuenta, double interes){
		super(titular, numeroCuenta);
		this.setInteres(interes);
	}
	
	public String toString(){
		return super.toString() + "\n\tInteres: " + this.getInteres() + " anual"; 
	}

	private double interes;

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	public void calcularInteres(){
		this.setSaldo(this.getSaldo()*(1+this.getInteres()/100));
	}
	
	
	
}
