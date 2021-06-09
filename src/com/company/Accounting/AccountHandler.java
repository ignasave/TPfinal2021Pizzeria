package com.company.Accounting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountHandler {



    public AccountHandler() {

    }


    public  static <T> List<T> openListFileToArray(List<T> a, String filename){

        //lee el archivo  incomes.json y pasa su contenido a incomesArray para no perder
        // los datos ya que  despues el arreglo siempre sobreescribe el archivo


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;



        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            a = gson.fromJson(reader,new TypeToken<List<T>>(){}.getType());
/*
            if(option >=0){
                mostrarGastos(option,a);
            }
*/
        }catch(IOException e){
            System.out.println("Creando Archivo: "+ filename);
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }


        return a;
    }





    public  static <T> List<T> writingListFile(List <T> a , String filename,T dato){


        //sobreescribe archivo con el expensesArray (donde estan todos los ingresos)

        List<T> x  = openListFileToArray(a,filename);
        x.add(dato);



        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try{

            fSalida = new BufferedWriter(new FileWriter(new File( filename)));
            String json = gson.toJson(x,x.getClass());
            //System.out.println( "soy el string jason \n " + json);
            fSalida.write(json);

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fSalida != null){
                try{
                    fSalida.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return x;
    }



    public  static String createFileName(String begins) {     // adds year and month to "expenses-"
        // when a new month begins it will create a new file and the last one will be
        LocalDate date = LocalDate.now();

        begins += date;
        String filename =  begins.substring(0, begins.length() - 3);
        filename += ".json";

        return filename;
    }




/*

    public static boolean addToFilenameArray(String filename, String [] fileNameArray){

        //checks if the filename is or not in the filenameArray file

        boolean flag = false;   //the filename in the parameter doesnt exist in the array so i have to add it

        for(String fn : fileNameArray){
            if( fn != null && fn.equals(filename)){
                flag = true;
            }
        }
        if(!flag){
            fileNameArray[fileNameArray.length -1] = filename;
        }

        return flag;
    }
*/






    public  static String[] filenameFileRead(String filename, String[]fileNameArray){
        //reads file  filenames.json

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("filenames.json")));
            fileNameArray = gson.fromJson(reader,new TypeToken<String[]>(){}.getType());

        }catch(IOException e){
            System.out.println("creando archivo");
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return fileNameArray;

    }


    public static void  filenameToFilenameArray(String filename , String [] filenameArray){   //sobreescribe archivo con el employeeArray (donde estan todos los empleados)

        filenameArray = filenameFileRead(filename ,filenameArray);

        //checks if the filename is or not in the filenameArray file

        boolean flag = false;   //the filename in the parameter doesnt exist in the array so i have to add it
/*
        for(String fn : filenameArray){
            if( fn != null && fn.equals(filename)){
                flag = true;
            }
        }
        if(!flag){
            filenameArray[filenameArray.length -1] = filename;
        }
*/
        int i = 0;

        for ( i = 0;i < filenameArray.length;i++){
            if(filenameArray[i] != null){
                if(filenameArray[i].equals(filename)){
                    flag = true;
                    break;
                }
            }else{
                filenameArray[i] =filename;
                break;
            }

        }

        if(!flag){//if the filename is not in the filenameArray we re-write the filenameArray file
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedWriter fSalida  = null;
            try{

                fSalida = new BufferedWriter(new FileWriter(new File( "filenames.json")));
                String json = gson.toJson(filenameArray,filenameArray.getClass());
                System.out.println( "soy el string jason de filename \n " + json);
                fSalida.write(json);

            }catch(IOException e){
                System.out.println("Creando archivo employee.json");
            }finally{
                if(fSalida != null){
                    try{
                        fSalida.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void printFileName(String[]fileNameArray,String begins){

        if(begins.equals("exp")){
            System.out.println("\nNombre de archivos expenses");
        }else{
            System.out.println("\nNombre de archivos tickets");
        }

        System.out.println("------------------------------------------");
        for(String fn:fileNameArray){
            if(fn != null && fn.contains(begins)){
                System.out.println(fn);

            }
        }
        System.out.println("------------------------------------------");
    }


    public static void printFilenameFile(String []fileNameArray,String begins){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("filenames.json")));
            fileNameArray = gson.fromJson(reader,new TypeToken<String[]>(){}.getType());

            printFileName(fileNameArray,begins);     ///print content of  expenses

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }


}
