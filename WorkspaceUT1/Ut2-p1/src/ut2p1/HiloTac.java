package ut2p1;


public class HiloTac extends Thread{
	
	public void run(){
		for(double i = 0; i<10000000;i+=Math.random());
		System.out.println("TAC");
			
		/*	//for(double i = 0; i<100000;i+=Math.random());
		try{
			PrintWriter pw = new PrintWriter(
					new FileWriter("/home/alumno/res.txt",true));
			pw.println("TAC");
			pw.close();
			}catch(Exception e){}*/
	}

}
