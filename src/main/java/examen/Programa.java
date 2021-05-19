/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import static examen.LecturaCSV.leeFicheroCSV;
import static examen.LecturaJSON.leeFicheroJSON;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author raquel
 */
public class Programa {

    public static void main(String[] args) {

        //id fichero de las asignaturas
        String idFichero = "nombresModulos.csv";
        //id fichero json
        String idJson = "calificacionesGrupo.json";

//        //prueba lectura
//        TreeMap<String,String> mapa = leeFicheroCSV(idFichero);
//        //prueba creacion mapa
//        System.out.println("----Impresion por pantalla del TREEMAP---");
//        for (Map.Entry<String, String> entry : mapa.entrySet()) {
//
//            System.out.println("Iniciales: " + entry.getKey() + "\tNombre modulo: " + entry.getValue());
//
//        }
        //prueba lectura json
        //leeFicheroJSON(idJson);
        
        //prueba de registros to alumnado
        System.out.println("-------LISTA DE ALUMNOS-------");
        RegistrosToAlumnado registro = new RegistrosToAlumnado();
                
        ArrayList<Alumnado> listaAlumnos = registro.devuelveAlumnadoDeRegistro(leeFicheroJSON(idJson));
        
        Collections.sort(listaAlumnos);
        
        listaAlumnos.forEach(System.out::println);

    }

}
