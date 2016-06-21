
import java.net.ServerSocket; //recibe conexiones
import java.net.Socket;  //se conecta a un servidor remoto
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Servidor{
    private DataOutputStream salida;
    Scanner input=new Scanner(System.in);
	private int puerto = 4444;
    private boolean opcion=true;


	public void recibirConexiones(int puerto){
		try{

				System.out.println("Recibiendo conexiones en el puerto "+  puerto);
				ServerSocket servidor = new ServerSocket(puerto);
			while(opcion){
				Socket cliente = servidor.accept();
				PrintWriter escritor = new PrintWriter(cliente.getOutputStream());
				BufferedReader lector= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				escritor.println("Bienvenido!!!");
				String linea;
				while((linea=lector.readLine()) !=null){
					if (linea.equals("/quit")) {
                        System.out.println("el tipo se fue ");
						cliente.close();
						escritor.flush();
						break;
						
					}
					System.out.println("el visitante ha dicho: "+ linea);
                        
				}
				
		salida=new DataOutputStream(cliente.getOutputStream());
			}
		}catch(Exception e){
			System.err.println("Error al recibir");
			e.printStackTrace();

		}
				

	}
    public void mostrarTexto( String s){
System.out.print(s);
}
    public void enviar(String s ){
        try {
            salida.writeUTF("server: " + s);    
           salida.flush();
        } catch (IOException ex) {
        }
    }
    public void escribir(){
    while(opcion){
    enviar(input.nextLine());
    }
    }
}
       