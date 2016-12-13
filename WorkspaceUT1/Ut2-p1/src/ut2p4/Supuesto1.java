package ut2p4;

public class Supuesto1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Caja caja1 = new Caja();
		caja1.inicio = System.currentTimeMillis();
		
		Cliente[] clientes = new Cliente[4];
		int[] ar1 = {2,2,1,2};
		clientes[0] = new Cliente("c1",ar1);
		int[] ar2={1,3,1,1,1,1};
		clientes[1] = new Cliente("c2",ar2);
		int[] ar3={1,1,1};
		clientes[2] = new Cliente("c3",ar3);
		int[] ar4={2,5};
		clientes[3] = new Cliente("c4",ar4);
		
		for(int i=0; i<clientes.length;i++){
			caja1.pasarCliente(clientes[i]);
		}
	}

}
