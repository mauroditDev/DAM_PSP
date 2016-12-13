package ut2p6;

public class Cuenta {

	private double saldo;
	private int numero_reintegros;
	
	public Cuenta(double s){
		saldo = s;
		numero_reintegros = 0;
	}
	
	public Cuenta(double s, int re){
		saldo = s;
		numero_reintegros = re;
	}
	
	public double getSaldo(){
		return saldo;
	}
	
	public int getReintegros(){
		return numero_reintegros;
	}
	
	public synchronized boolean retirar(double cant){
		if(comprobar(cant)){
			saldo -= cant;
			numero_reintegros++;
			return true;
		}
		else
			return false;
	}
	
	private synchronized boolean comprobar(double cant){
		if(saldo < cant){
			return false;
		}
		else{
			return true;
		}
	}
	
}
