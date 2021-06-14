/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

/**
 *
 * @author caleb
 */
public class Cliente {
    private static String genero, edad, sintoma;

    public static void almacenarDatos(String genero, String edad, String sintoma) {
        Cliente.genero = genero;
        Cliente.edad = edad;
        Cliente.sintoma = sintoma;
    }

    
    
    public static String getGenero() {
        return genero;
    }

    public static void setGenero(String genero) {
        Cliente.genero = genero;
    }

    public static String getEdad() {
        return edad;
    }

    public static void setEdad(String edad) {
        Cliente.edad = edad;
    }

    public static String getSintoma() {
        return sintoma;
    }

    public static void setSintoma(String sintoma) {
        Cliente.sintoma = sintoma;
    }
    
    public static void limpiarDatos(){
        Cliente.genero = "";
        Cliente.edad = "";
        Cliente.sintoma = "";
    }
    
}
