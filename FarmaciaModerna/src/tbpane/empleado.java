/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbpane;

import java.math.BigDecimal;

/**
 *
 * @author edgargarcia
 */
public class empleado {
    private String id,nombre,apellidop,apellidom,idfar,sucursal,telefono,numero,calle,colonia,ciudad,estado,cp;
    
    public empleado(String id,String nombre,String apellidop,String apellidom,String idfar,String sucursal,String telefono,String numero, String calle,String colonia, String ciudad,String estado,String cp){
        this.id=id;
        this.nombre=nombre;
        this.apellidop=apellidop;
        this.apellidom=apellidom;
        this.idfar=idfar;
        this.sucursal=sucursal;
        this.telefono=telefono;
        this.numero=numero;
        this.calle=calle;
        this.colonia=colonia;
        this.ciudad=ciudad;
        this.estado=estado;
        this.cp=cp;
    }

    public empleado(String string, String string0, String string1, String string2, String string3, int aInt, BigDecimal bigDecimal, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public empleado(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getid(){
        return id;
    }
    public void setid(String id){
        this.id=id;
    }
    
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getapellidop(){
        return apellidop;
    }
    public void setapellidop(String apellidop){
        this.apellidop=apellidop;
    }
    
    public String getapellidom(){
        return apellidom;
    }
    public void setapellidom(String apellidom){
        this.apellidom=apellidom;
    }
    
    public String getidfar(){
        return idfar;
    }
    public void setidfar(String idfar){
        this.idfar=idfar;
    }
    
    public String getsucursal(){
        return sucursal;
    }
    public void setsucursal(String sucursal){
        this.sucursal=sucursal;
    }
    
    public String gettelefono(){
        return telefono;
    }
    public void settelefono(String telefono){
        this.telefono=telefono;
    }
    
    public String getnumero(){
        return numero;
    }
    public void setnumero(String numero){
        this.numero=numero;
    }
    
    public String getcalle(){
        return calle;
    }
    public void setcalle(String calle){
        this.calle=calle;
    }
    
    public String getcolonia(){
        return colonia;
    }
    public void setcolonia(String colonia){
        this.colonia=colonia;
    }
    
    public String getciudad(){
        return ciudad;
    }
    public void setciudad(String ciudad){
        this.ciudad=ciudad;
    }
    
    public String getestado(){
        return estado;
    }
    public void setestado(String estado){
        this.estado=estado;
    }
    
    public String getcp(){
        return cp;
    }
    public void setcp(String cp){
        this.cp=cp;
    }
    
}
