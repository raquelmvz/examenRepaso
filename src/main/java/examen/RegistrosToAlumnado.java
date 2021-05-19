/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author raque
 */
public class RegistrosToAlumnado {

    /* Metodo que recibe una lista de objetos de tipo RegistroJSON
    Devuelve una lista de objetos de tipo Alumnado */
    public ArrayList<Alumnado> devuelveAlumnadoDeRegistro(ArrayList<RegistroJSON> lista) {

        ArrayList<Alumnado> listaADevolver = new ArrayList<>();
        ArrayList<String> listaIniciales = RegistroJSON.devuelveCamposJsonproperty();

        for (RegistroJSON registro : lista) {

            Alumnado alumno = new Alumnado();

            TreeMap<String, String> calificacionesPorModulo = new TreeMap<>();

            alumno.setNombreAlumno(registro.getNombreAlumno());

            calificacionesPorModulo.put(listaIniciales.get(0), registro.getCalificacionCEAC());
            calificacionesPorModulo.put(listaIniciales.get(1), registro.getCalificacionEA());
            calificacionesPorModulo.put(listaIniciales.get(2), registro.getCalificacionFOL());
            calificacionesPorModulo.put(listaIniciales.get(3), registro.getCalificacionING());
            calificacionesPorModulo.put(listaIniciales.get(4), registro.getCalificacionOACV());
            calificacionesPorModulo.put(listaIniciales.get(5), registro.getCalificacionTC());
            calificacionesPorModulo.put(listaIniciales.get(6), registro.getCalificacionTII());

            alumno.setCalificacionPorModulo(calificacionesPorModulo);

            listaADevolver.add(alumno);

        }

        return listaADevolver;
    }

}
