/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author edgar
 */
public class Socket2 {
    public static void main(String[] args) {
ServerSocket servidor = null;
		Socket so = null;
		DataInputStream in;
		DataOutputStream out;
		final int PUERTO = 5000;
                String nombreS []=new String[5];
				int t=0;
		try{
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			while(true){

				so = servidor.accept();
				System.out.println("conexion establecida");
				in = new DataInputStream(so.getInputStream());
				out = new DataOutputStream(so.getOutputStream());
                                nombreS[t]= in.readUTF();
				out.writeUTF("El Ultimo usuario conectado fue:"+nombreS[t]);
				t++;
				System.out.println("--Lista de conexiones--");
				for(int w=0;w<=4;w++){
					System.out.println(nombreS[w]);
				}
				if(t==5){
				System.out.println("Conexiones llenas");
				servidor.close();
				}
				
			}

		}catch(IOException ex){
			
			System.out.println(ex);
		}
    
}
}