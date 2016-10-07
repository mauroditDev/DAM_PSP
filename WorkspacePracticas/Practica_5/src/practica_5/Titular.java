package practica_5;

public class Titular {

	public Titular(){
		
	}
	
	public Titular(String nombre, String apellidos, int edad){
		this.setApellidos(apellidos);
		this.setNombre(nombre);
		this.setEdad(edad);
	}
	
	public String toString(){
		
		return this.getNombre() + " " + this.getApellidos();
		
	}
	
	private String nombre;
	
	private String apellidos;
	
	private int edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}
