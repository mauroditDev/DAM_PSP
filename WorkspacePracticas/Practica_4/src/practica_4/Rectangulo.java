package practica_4;

public class Rectangulo implements Poligono {

	private double altura;
	private double base;
	
	@Override
	public double calcularArea() {
		
		return this.getAltura() * this.getBase();
		
	}
	
	@Override
	public String toString(){
		return "Rectangulo de lado: "+ this.getBase() +
				" de altura: " + this.getAltura() + 
				"\n\tcon area: " + this.calcularArea();
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
	
	

}
