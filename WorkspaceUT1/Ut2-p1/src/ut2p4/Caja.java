package ut2p4;

public class Caja {
	public double inicio;
	
	public void pasarCliente(Cliente cli){
		System.out.println("Entra cliente "+cli.nombre+
				" en instante: "+String.valueOf(
						(System.currentTimeMillis()-inicio)/1000)+" seg");
		for(int i = 0; i<cli.productos.length; i++){
			System.out.println("Producto "+i+": "+cli.productos[i]+"segs");
			procesar(cli.productos[i]);
		}
		System.out.println("Cliente "+cli.nombre+
				" termina en instante: "+String.valueOf(
						(System.currentTimeMillis()-inicio)/1000)+" seg");
	}
	
	public void procesar(int producto){
		try{
			Thread.sleep(producto*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
