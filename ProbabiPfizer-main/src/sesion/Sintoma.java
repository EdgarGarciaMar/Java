/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.math.BigDecimal;

/**
 *
 * @author caleb
 */
public class Sintoma {
    private String nombre;
    private int numeroEventos;
    private BigDecimal probabilidad, porcentajeProbabilidad;

    public Sintoma(String nombre, int numeroEventos, BigDecimal probabilidad) {
        this.nombre = nombre;
        this.numeroEventos = numeroEventos;
        this.probabilidad = probabilidad;
        porcentajeProbabilidad = probabilidad.multiply(new BigDecimal(100));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEventos() {
        return numeroEventos;
    }

    public void setNumeroEventos(int numeroEventos) {
        this.numeroEventos = numeroEventos;
    }

    public BigDecimal getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(BigDecimal probabilidad) {
        this.probabilidad = probabilidad;
        porcentajeProbabilidad = probabilidad.multiply(new BigDecimal(100));
    }

    public BigDecimal getPorcentajeProbabilidad() {
        return porcentajeProbabilidad;
    }
    
}
