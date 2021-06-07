package com.company.Accounting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileHandling {


    public FileHandling() {

    }

    public static <T> List<T> openListFileToArray(List<T> a, String filename) {

        //lee el archivo  incomes.json y pasa su contenido a incomesArray para no perder
        // los datos ya que  despues el arreglo siempre sobreescribe el archivo


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;


        try {

            reader = new BufferedReader(new FileReader(new File(filename)));
            a = gson.fromJson(reader, new TypeToken<List<T>>() {
            }.getType());


        } catch (IOException e) {
            System.out.println("Creando Archivo: " + filename);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return a;
    }


    public static <T> List<T> writingListFile(List<T> a, String filename, T dato) {

        //sobreescribe archivo con el expensesArray (donde estan todos los ingresos)

        List<T> x = openListFileToArray(a, filename);
        x.add(dato);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida = null;
        try {

            fSalida = new BufferedWriter(new FileWriter(new File(filename)));
            String json = gson.toJson(x, x.getClass());
            //System.out.println( "soy el string jason \n " + json);
            fSalida.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fSalida != null) {
                try {
                    fSalida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return x;
    }


}

