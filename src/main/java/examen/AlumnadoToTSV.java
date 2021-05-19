/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author raque
 */
public class AlumnadoToTSV {

    /* Metodo que recibe un objeto de tipo Alumnado y el map del ej 1
    En la carpeta ./alumnado se crea un TSV con el nombre nombredelalumno(sin espacios).tsv 
    una linea por modulo
     */
    public static void escribirTSV(Alumnado alumnado, TreeMap<String, String> modulos) {

        String idFichero = "./alumnado/" + alumnado.getNombreAlumno().concat(".tsv").replace(" ", "");//sin espacios

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Map.Entry<String, String> entry : alumnado.getCalificacionPorModulo().entrySet()) {

                String nombreAsignatura;

                nombreAsignatura = buscarNombre(modulos, entry.getKey());

                flujo.write(nombreAsignatura + "\t" + entry.getValue());
                flujo.newLine();
            }

            System.out.println("Fichero " + alumnado.getNombreAlumno().concat(".tsv").replace(" ", "") + " creado correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /* Del mapa asignaturas busco la inicial que paso por parametro y te devuelve el nombre completo de la asignatura */
    private static String buscarNombre(Map<String, String> asignaturas, String inicial) {

        for (Map.Entry<String, String> entry : asignaturas.entrySet()) {

            if (inicial.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

}
