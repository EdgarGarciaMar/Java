/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiperros;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author edgar
 */
public class conexion {
    private Connection conect;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String usuario = "root";//usuario bd
    private String pass = "ABc12345678";//contraseña bd
    private String url = "jdbc:mysql://localhost:3306/perros?serverTimezone=UTC";//direccion localhost, nombre bd, zona horaria de la bd
    
    public conexion(){//conexion con bd
        
        try{
            Class.forName(driver);
            conect = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexion establecida");
            
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void desconectar() throws SQLException{
        
        try {
             conect.close();
             System.out.println("conexion terminada");
             
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insertar(int noperro, String nombre, String raza, int edad, String genero ) throws SQLException{//metodo para incertar datos
        PreparedStatement stm;
        stm = conect.prepareStatement("INSERT INTO perro VALUES (?,?,?,?,?)");// comando sql donde values(?,?,?...)son las columnas de la tabla
        stm.setInt(1,noperro);//valores que le pasamos al insert (numero de columna, valor)
        stm.setString(2,nombre);
        stm.setString(3,raza);
        stm.setInt(4,edad);
        stm.setString(5,genero);
        stm.executeUpdate();// metodo para ejecutar el insert
    }
    
    public void consulta() throws SQLException{//metodo para consulta de datos
        int id, edad;
        String nombre,raza,genero;
        Statement stmt = conect.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM perro");//comando sql select 
        System.out.println("ID Nombre Raza Edad Genero");
        while (result.next()) {//consulta de datos fila por fila
         id = result.getInt("Noperro");
         nombre = result.getString("Nombre");
         raza = result.getString("Raza");
         edad = result.getInt("Edad");
         genero = result.getString("Genero");
         System.out.println(id+" "+nombre+" "+raza+" "+edad+" "+genero);
        }
            result.close();//termina la consulta
    }
    
   
}
