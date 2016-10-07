package ut0p7;

import java.util.ArrayList;

public class Archivador {

	private ArrayList<Paciente> listado;
	
	public void guardar(Paciente p){
		listado.add(p);
	}
	
	public void eliminar(int i){
		listado.remove(i);
	}
	
	public void listar(){
		for(int i = 0; i< listado.size();i++){
			System.out.println(listado.get(i).getNombre()+" "+listado.get(i).getApellido());
		}
	}
}
