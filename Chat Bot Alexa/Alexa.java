
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Alexa {
    HashMap<String,ArrayList<String>> answers = new HashMap<String,ArrayList<String>>();
    public Alexa(){
        p();
        System.out.println("Alexa Online :)");
    }
 
    public String responder(String pregunta){
        String respuesta ="";
        boolean coincidencias = false;
		
        for(HashMap.Entry<String,ArrayList<String>> entrada : answers.entrySet()){
            if(pregunta.contains(entrada.getKey())){
                coincidencias = true;
                ArrayList<String> respuestas = entrada.getValue();
                int IRandom =(int)(Math.random() * respuestas.size());
                switch(entrada.getKey()){
                    case "hora":
                        respuesta = respuestas.get(IRandom) + obtenerHoraFormateada();
                        break;
                    case "dia":
                        respuesta = respuestas.get(IRandom) + obtenerFechaFormateada();
                        break;
                    default:
                        respuesta = respuestas.get(IRandom);
                        break;
                }
            }
        }
        if(coincidencias == false){
            ArrayList<String> sinrespuesta = answers.get("indefinido");
            int IRandom=(int)(Math.random() * sinrespuesta.size());
            respuesta = sinrespuesta.get(IRandom);
        }
        return respuesta;
    }
    
    public String obtenerHoraFormateada(){
		LocalTime tiempo = LocalTime.now();
        return tiempo.format(DateTimeFormatter.ofPattern("HH:mm"));
        
    }
    public String obtenerFechaFormateada(){
		Date fecha= new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
	
	public void p(){
        answers.put("hora", new ArrayList<String>());
        answers.get("hora").add("Son las");
        answers.get("hora").add("La hora es");
        answers.get("hora").add("La hora actual es");
        
        answers.put("escuela", new ArrayList<String>());
        answers.get("escuela").add("ESCOM-IPN");
        answers.get("escuela").add("Estudio ESCOM");
        answers.get("escuela").add("En la mejor escuela ESCOM");
        
        answers.put("deporte", new ArrayList<String>());
        answers.get("deporte").add("El futbol americano");
        answers.get("deporte").add("El futbol soccer");
        answers.get("deporte").add("La formula 1");
        
        answers.put("ciudad", new ArrayList<String>());
        answers.get("ciudad").add("de la CDMX");
        answers.get("ciudad").add("Existo en Ciudad de Mexico");
        answers.get("ciudad").add("from Mexico city");
        
        answers.put("chiste", new ArrayList<String>());
        answers.get("chiste").add("Mmmm, velas!, que celebramos? \n - Que nos han cortado la luz..");
        answers.get("chiste").add("Que le habla un bit al otro? \n Nos vemos en el bus.");
        answers.get("chiste").add("Error 0094782: No se detecta ningun teclado pulse una tecla para continuar.");
        
        answers.put("edad", new ArrayList<String>());
        answers.get("edad").add("Tengo 18");
        answers.get("edad").add("vivio desde el 2001");
        answers.get("edad").add("Tengo 10010");
        
        answers.put("pais", new ArrayList<String>());
        answers.get("pais").add("Mexico");
        answers.get("pais").add("vivio en Mexico");
        answers.get("pais").add("Soy Azteca");
        
        answers.put("dia", new ArrayList<String>());
        answers.get("dia").add("Hoy es");
        answers.get("dia").add("Estamos a");
        answers.get("dia").add("Es");
        
        answers.put("indefinido", new ArrayList<String>());
        answers.get("indefinido").add("Lo siento, no entendi lo que dices");
        answers.get("indefinido").add("Perdon no se que responder");
        answers.get("indefinido").add("Lo siento, no se que decir, estudiare mas para que no pase de nuevo");
        
        answers.put("hola", new ArrayList<String>());
        answers.get("hola").add("Hola, es un placer saludarte");
        answers.get("hola").add("Hola, que tal tu cuarentena?");
        answers.get("hola").add("Hola!!");
    }

}
