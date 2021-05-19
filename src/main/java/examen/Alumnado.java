/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author raque
 */
public class Alumnado implements Comparable<Alumnado> {

    private String nombreAlumno;
    private TreeMap<String, String> calificacionPorModulo;

    public Alumnado() {
    }

    public Alumnado(String nombreAlumno, TreeMap<String, String> calificacionPorModulo) {
        this.nombreAlumno = nombreAlumno;
        this.calificacionPorModulo = calificacionPorModulo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public TreeMap<String, String> getCalificacionPorModulo() {
        return calificacionPorModulo;
    }

    public void setCalificacionPorModulo(TreeMap<String, String> calificacionPorModulo) {
        this.calificacionPorModulo = calificacionPorModulo;
    }

    @Override
    public String toString() {
        return nombreAlumno + "\n\t" + obtenerCalificaciones(calificacionPorModulo);
    }

    @Override
    public int compareTo(Alumnado o) {
        return this.getNombreAlumno().compareTo(o.getNombreAlumno());
    }
    
    public static String obtenerCalificaciones(TreeMap<String,String> calificaciones) {
        String contenidoMap = "";
        String valoresAlmacenados = "";
        
        for (Map.Entry<String,String> mapRecorrer : calificaciones.entrySet()) {
            contenidoMap = " [" + mapRecorrer.getKey() + ": " + mapRecorrer.getValue() + "]";
            valoresAlmacenados += contenidoMap;
        }
        
        return valoresAlmacenados;
    }

}
