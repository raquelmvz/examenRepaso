/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author raque
 */
public class RegistroJSON {

    @JsonProperty("Alumno/a")
    private String nombreAlumno;
    @JsonProperty("OACV")
    private String calificacionOACV;
    @JsonProperty("EA")
    private String calificacionEA;
    @JsonProperty("TII")
    private String calificacionTII;
    @JsonProperty("TC")
    private String calificacionTC;
    @JsonProperty("ING")
    private String calificacionING;
    @JsonProperty("FOL")
    private String calificacionFOL;
    @JsonProperty("CEAC")
    private String calificacionCEAC;

    public RegistroJSON() {
    }

    public RegistroJSON(String nombreAlumno, String calificacionOACV, String calificacionEA, String calificacionTII, String calificacionTC, String calificacionING, String calificacionFOL, String calificacionCEAC) {
        this.nombreAlumno = nombreAlumno;
        this.calificacionOACV = calificacionOACV;
        this.calificacionEA = calificacionEA;
        this.calificacionTII = calificacionTII;
        this.calificacionTC = calificacionTC;
        this.calificacionING = calificacionING;
        this.calificacionFOL = calificacionFOL;
        this.calificacionCEAC = calificacionCEAC;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getCalificacionOACV() {
        return calificacionOACV;
    }

    public void setCalificacionOACV(String calificacionOACV) {
        this.calificacionOACV = calificacionOACV;
    }

    public String getCalificacionEA() {
        return calificacionEA;
    }

    public void setCalificacionEA(String calificacionEA) {
        this.calificacionEA = calificacionEA;
    }

    public String getCalificacionTII() {
        return calificacionTII;
    }

    public void setCalificacionTII(String calificacionTII) {
        this.calificacionTII = calificacionTII;
    }

    public String getCalificacionTC() {
        return calificacionTC;
    }

    public void setCalificacionTC(String calificacionTC) {
        this.calificacionTC = calificacionTC;
    }

    public String getCalificacionING() {
        return calificacionING;
    }

    public void setCalificacionING(String calificacionING) {
        this.calificacionING = calificacionING;
    }

    public String getCalificacionFOL() {
        return calificacionFOL;
    }

    public void setCalificacionFOL(String calificacionFOL) {
        this.calificacionFOL = calificacionFOL;
    }

    public String getCalificacionCEAC() {
        return calificacionCEAC;
    }

    public void setCalificacionCEAC(String calificacionCEAC) {
        this.calificacionCEAC = calificacionCEAC;
    }

    @Override
    public String toString() {
        return nombreAlumno + "\t" + calificacionOACV + "\t" + calificacionEA
                + "\t" + calificacionTII + "\t" + calificacionTC
                + "\t" + calificacionING + "\t" + calificacionFOL
                + "\t" + calificacionCEAC;
        
    }
    
    /* Metodo que devuelve las anotaciones json properties de la clase */
    public static ArrayList<String> devuelveCamposJsonproperty() {
        Field[] fields = RegistroJSON.class.getDeclaredFields(); //campos declarados en la clase
        ArrayList<String> etiquetas = new ArrayList<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonProperty.class)) {
                String anotacion = field.getAnnotation(JsonProperty.class).value();
                etiquetas.add(anotacion);
            }
        }
        // borro la primera anotacion porque es la de nombre de alumno
        // solo quiero las iniciales de las asignaturas
        etiquetas.remove(0);
        Collections.sort(etiquetas); // para que los modulos se ordenen alfabeticamente
        
        return etiquetas;
    }
    
 

}
