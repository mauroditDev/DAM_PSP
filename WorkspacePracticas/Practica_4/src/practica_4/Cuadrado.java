package practica_4;

public class Cuadrado implements Poligono {

	private double lado;
	
	@Override
	public double calcularArea() {
		return Math.pow(this.getLado(), 2);
	}
	
	@Override
	public String toString(){
		return "Cuadrado de lado: "+this.getLado()+"\n\tcon area: "+this.calcularArea();
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	

}
