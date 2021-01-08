
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class p4S{
	
	public static void main(String[] args) {
		
		ServerSocket servidor = null;
		Socket so = null;
		DataInputStream in;
		DataOutputStream out;
		final int PUERTO = 5000;
		

		try{
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			while(true){

				so = servidor.accept();
				System.out.println("conexion establecida");
				in = new DataInputStream(so.getInputStream());
				out = new DataOutputStream(so.getOutputStream());

				out.writeUTF("Hola Mundo!!!");
				servidor.close();
				System.out.println("conexion terminada");
			}

		}catch(IOException ex){
			
			System.out.println(ex);
		}
	}
}
		