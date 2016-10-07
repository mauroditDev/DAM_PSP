package practica9;

public class BonoMetro {

	private int viajesRestantes;

	public int getViajesRestantes() {
		return viajesRestantes;
	}

	public void setViajesRestantes(int viajesRestantes) {
		this.viajesRestantes = viajesRestantes;
	}
	
	public void viajar()throws SinViajesException{
		if(this.getViajesRestantes()>0)
			this.setViajesRestantes(this.getViajesRestantes()-1);
		else
			throw new SinViajesException();
	}
	
}
