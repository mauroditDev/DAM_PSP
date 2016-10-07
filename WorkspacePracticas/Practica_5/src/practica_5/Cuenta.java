package practica_5;

public class Cuenta {

	public Cuenta(){
		id++;
	}
	
	public Cuenta(Titular titular, String numeroCuenta, double saldo){
		id++;
		this.setTitular(titular);
		this.setSaldo(saldo);
		this.setNumeroCuenta(numeroCuenta);
		
	}
	
	public Cuenta(Titular titular, String numeroCuenta){
		id++;
		this.setTitular(titular);
		this.setSaldo(100);
		this.setNumeroCuenta(numeroCuenta);
		
	}
	
	public String toString(){
		return this.getTitular().toString()+"\nCuenta nro. : "+this.getNumeroCuenta()
				+"\n\tSaldo: "+this.getSaldo();
	}
	
	private Titular titular;
	
	private String numeroCuenta;
	
	private double saldo;

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void saldoSuma(double cant){
		this.setSaldo(this.getSaldo()+cant);
	}
	
	public void saldoResta(double cant){
		this.setSaldo(this.getSaldo()-cant);
	}
	
	public boolean comparar(Cuenta other){
		if(this.getNumeroCuenta().compareTo(other.getNumeroCuenta())==0)
			return true;
		else
			return false;
	}
	
	public static int mostrarContador(){
		
		return id;
		
	}
	
	public double getSaldoMin() {
		return saldoMin;
	}

	public void setSaldoMin(double saldoMin) {
		this.saldoMin = saldoMin;
	}

	private static int id = 0;
	
	private double saldoMin;
	
}
