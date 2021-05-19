/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author raque
 */
public class LecturaCSV {

    /* Metodo que permite la lectura de un fichero CSV
    de la raiz del proyecto
    Recibe el nombre y la ruta del fichero a leer
    Devuelve un Map ordenado --> key: iniciales, values: nombre modulo */
    public static TreeMap<String, String> leeFicheroCSV(String idFichero) {

        /* Para guardar los valores que se van leyendo */
        String[] tokens;
        String linea;
        TreeMap<String, String> asignaturas = new TreeMap<>();

        /*Instanciación de BufferedReader a partir de un objeto InputStreamReader
        InputStreamReader permite indicar el tipo de codificación del archivo */
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(idFichero), "UTF-8"))) {

            //quitamos la cabecera
            br.readLine();

            //mientras el metodo readline no devuelva null es que existen datos por leer
            while ((linea = br.readLine()) != null) {

                tokens = linea.split(";"); //se guarda cada elemento de la linea en funcion del separador

                asignaturas.put(tokens[0].trim(), tokens[1].trim());

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //impresion por consola
        System.out.println("--------LECTURA DEL FICHERO----------");
        for (Map.Entry<String, String> entry : asignaturas.entrySet()) {

            System.out.println("Iniciales: " + entry.getKey() + "\tNombre modulo: " + entry.getValue());

        }

        return asignaturas;

    }

}
