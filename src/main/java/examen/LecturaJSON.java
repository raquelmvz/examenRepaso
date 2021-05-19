/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raque
 */
public class LecturaJSON {

    /* Metodo que permite la lectura del fichero json
    Recibe el nombre y la ruta del fichero
    Devuelve una esctructura ArrayList de objetos RegistroJSON
    Todo en string mejor */
    public static ArrayList<RegistroJSON> leeFicheroJSON(String idFichero) {

        ArrayList<RegistroJSON> calificaciones = new ArrayList<>();

        try {

            ObjectMapper mapeador = new ObjectMapper();

            calificaciones = mapeador.readValue(new File(idFichero),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, RegistroJSON.class));

            System.out.println("-----LECTURA DE LAS CALIFICACIONES-----");
            for (RegistroJSON registro : calificaciones) {
                System.out.println(registro);
            }

        } catch (IOException ex) {
            Logger.getLogger(LecturaJSON.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de lectura en el fichero JSON");
        }

        return calificaciones;

    }

}
