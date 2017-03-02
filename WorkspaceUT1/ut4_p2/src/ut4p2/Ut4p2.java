package ut4p2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.commons.net.ftp.*;

public class Ut4p2 {
	
	public static void main(String[] args){
		
		try{
			Scanner sc = new Scanner(System.in);
			FTPClient cliente = new FTPClient();
			cliente.connect("172.26.104.173",1980);
			if (FTPReply.isPositiveCompletion(cliente.getReplyCode())) {
				cliente.user("userftp");
				cliente.pass("dam");
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				
				System.out.println("Elige: Descargar o Subir fichero (d or s)");
				String orden = sc.nextLine();
				
				while(orden.equals("d")||orden.equals("s")){
					switch(orden){
					case "s":
						String pathname = "MAURO_DI_TULLIO";
						cliente.changeWorkingDirectory("/upload");
						if(cliente.makeDirectory(pathname)){
							System.out.println("se ha creado el directorio /upload/"+pathname);
						}
						else{
							System.out.println("no se ha creado el directorio, es posible que ya existiera");
							System.out.println(cliente.getReplyCode()+": "+cliente.getReplyString());
						}
						if(cliente.changeWorkingDirectory("/upload/"+pathname)){
							
							String continuar = "s";
							while(continuar.equals("s")){
								System.out.println(
									"nombre del archivo a copiar (debe estar en la carpeta: "+
									new File(".").getAbsolutePath()+")"
								);
								String archivoAcopiar = sc.nextLine();
								try{
									BufferedInputStream entrada = new BufferedInputStream (
										new FileInputStream ("./"+archivoAcopiar)
									);
									if(cliente.storeFile(archivoAcopiar, entrada)){
										System.out.println("copiado exitosamente");
									}
									else{
										System.out.println("no pudo copiarse");
										System.out.println(cliente.getReplyCode()+": "+cliente.getReplyString());
									}
									entrada.close();
								}catch(FileNotFoundException fnfEx){
									System.out.println("el archivo no existe en "+new File(".").getAbsolutePath());
								}
								System.out.println("desea copiar otro archivo? (s/n)");
								continuar = sc.nextLine();
							}
							System.out.println("Desea renombrar un fichero? (s/n)");
							while(sc.nextLine().equals("s")){
								System.out.println("nombre del archivo a renombrar");
								String nombreArchivo = sc.nextLine();
								System.out.println("nombre objetivo para el archivo");
								if(cliente.rename(
										cliente.printWorkingDirectory()+"/"+nombreArchivo,
										cliente.printWorkingDirectory()+"/"+sc.nextLine())
								){
									System.out.println("renombrado!");
								}
								else{
									System.out.println("no ha podido renombrarse");
									System.out.println(cliente.getReplyCode()+": "+cliente.getReplyString());
								}
								System.out.println("Desea borrar otro fichero? (s/n)");
							}
							System.out.println("Desea borrar un fichero? (s/n)");
							while(sc.nextLine().equals("s")){
								System.out.println("nombre del archivo a borrar");
								String nombreArchivo = sc.nextLine();
								if(cliente.deleteFile(cliente.printWorkingDirectory()+"/"+nombreArchivo)){
									System.out.println("borrado: "+cliente.printWorkingDirectory()+"/"+nombreArchivo);
								}
								else{
									System.out.println("no ha podido borrarse");
									System.out.println(cliente.getReplyCode()+": "+cliente.getReplyString());
								}
								System.out.println("Desea borrar otro fichero? (s/n)");
							}
							System.out.println("terminando aplicación...");
							
						}
						else{
							System.out.println("el directorio no existe");
						}
						break;
					case "d":
						String path = "/";
						int i = 0;
							listDir(path,cliente);
							System.out.println("escriba el nombre del archivo a descargar " +
									"(o el de un directorio para entrar)\n'exit' para salir");
							String cont = "a";
							while(!cont.equals("exit")){
								cont = sc.nextLine();
								if(!cont.equals("exit")){
									if(i==0)path = path + cont;
									else path = path +"/"+ cont;
									path = listDir(path,cliente);
									System.out.println("escriba el nombre del archivo a descargar " +
											"(o el de un directorio para entrar)\n'exit' para salir");
								}
								i++;
							}
						}
						break;
					}
					
				}
				
			sc.close();
			cliente.disconnect();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static String listDir(String pathname, FTPClient cliente){
		try {
			System.out.println(pathname);
			if(cliente.changeWorkingDirectory(pathname)){
				System.out.println("has escrito un directorio");
				FTPFile[] directorios = cliente.listFiles();
				for(int i = 0; i< directorios.length; i++){
					System.out.println(i+":");
					if(directorios[i].isDirectory())
						System.out.println("### CARPETA::: "+directorios[i].getName()+"*");
					else
						System.out.println(
								"--" + directorios[i].getName() + ": "
								+ directorios[i].getType() + " - "
							    + directorios[i].getSize() + "bytes"
							);
					System.out.println("---------------+---------------");
				}
			}
			else{
				System.out.println("has escrito un archivo");
				String[] nombreArchivo = pathname.split("/");
				File archivo = new File("./"+nombreArchivo[nombreArchivo.length-1]);
				BufferedOutputStream salida = new BufferedOutputStream (
						new FileOutputStream (archivo));
				if(cliente.retrieveFile(pathname, salida)){
					System.out.println("guardado archivo en:"+new File("./"+pathname).getAbsolutePath());
				}
				else{
					System.out.println("no pudo guardarse el archivo");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pathname;
	}
}
