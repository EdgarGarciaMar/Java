import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class p4C{

	public static void main(String[] args){

		final String HOST = "127.0.0.1";
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		
		try{
			Socket so = new Socket(HOST, PUERTO);
			in = new DataInputStream(so.getInputStream());
			out = new DataOutputStream(so.getOutputStream());
			String mensaje =in.readUTF();
			System.out.println(mensaje);
			so.close();

		}catch(IOException ex){
			
			System.out.println(ex);
		}

	}
}