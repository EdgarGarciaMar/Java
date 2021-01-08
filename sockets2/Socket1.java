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
import java.util.Scanner;
/**
 *
 * @author edgar
 */
public class Socket1 {
public static void main(String[] args){

		final String HOST = "127.0.0.1";
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
                String nombre;
                Scanner entrada= new Scanner(System.in);
                
		try{
			Socket so = new Socket(HOST, PUERTO);
			in = new DataInputStream(so.getInputStream());
			out = new DataOutputStream(so.getOutputStream());
                        System.out.println("Ingresa tu nombre:");
                        nombre =entrada.nextLine();
                        out.writeUTF(nombre);
			String mensaje =in.readUTF();
			System.out.println(mensaje);
			so.close();

		}catch(IOException ex){
			
			System.out.println(ex);
		}

}
}
