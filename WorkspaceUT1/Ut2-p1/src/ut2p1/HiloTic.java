package ut2p1;


public class HiloTic extends Thread{
	
	public void run(){
		
		for(double i = 0; i<10000000;i+=Math.random());
		System.out.println("TIC");
		
	
		/*try{
		PrintWriter pw = new PrintWriter(new FileWriter("/home/alumno/res.txt"));
		pw.println("TIC");
		pw.close();
		}catch(Exception e){}*/
			
	}

}
