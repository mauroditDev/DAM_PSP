package ut0p7;

public class Paciente {

	private String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	private String apellido;
	
	public Paciente(String n, String a){
		this.nombre = n;
		this.apellido = a;
	}
	
}
