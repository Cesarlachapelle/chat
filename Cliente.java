import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{
private int puerto;
private String ip;
private Socket socketCliente;
    
public void conexion(int puerto, String ip){
try {
    socketCliente=new Socket(ip,puerto);
    while (true){
    
        
        
				DataOutputStream dos = new DataOutputStream(
            socketCliente.getOutputStream());
     
        DataInputStream dis = new DataInputStream(System.in);
 
    String line = "";
    while (!line.equals("bye"))
    { 
        line = dis.readLine();
            dos.writeUTF(line);
        dos.flush();
					}

					System.out.println("Amigo: " + line);
    
    }
       
    socketCliente.close();
}catch(Exception ex){
    System.err.println("errror en la conexion");
}

}

}

