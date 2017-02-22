package ftp_1;

import org.apache.commons.net.ftp.*;

public class Ftp_1 {

	public static void main(String[] args){
		
		try{
			
			FTPClient cliente = new FTPClient();
			cliente.connect("ftp.rediris.es");
			if (FTPReply.isPositiveCompletion(cliente.getReplyCode())) {
				cliente.user("anonymous");
				FTPFile[] directorios = cliente.listDirectories();
				for(int i = 0; i< directorios.length; i++){
					FTPFile[] archivos = cliente.listFiles(directorios[i].toFormattedString());
					System.out.println("### CONTENIDO DE "+directorios[i].getName()+":");
					for( int j = 0 ; j < archivos.length ; j++ ){
						if(!archivos[j].isDirectory())
						System.out.println(
								"--"+archivos[j].getName()+": "
								+archivos[j].getType()+" - "
							    +archivos[j].getSize()+"bytes"
						);
					}
				}
			}

			cliente.disconnect();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
