package com.company.Accounting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StartingDay {

    private String dateInFile;
    private String filename;

    public StartingDay(){

        this.dateInFile = "";
        this.filename = "today.json";

        checkingNewday();
    }

    //region getter setter

    public String getDateInFile() {
        return dateInFile;
    }

    public void setDateInFile(String dateInFile) {
        this.dateInFile = dateInFile;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    //endregion



    public  void checkingNewday(){
        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.now();

        String today = "";
        today += date;

        boolean flag = checkingTodayFileContent();    ///checks if is information into today.json file

        if(flag){   //if is a date into today.json file

            if(today.equals(dateInFile)){  //same date
                try{
                    System.out.println("Hubo un cierre no programado del sistema. Por favor ingrese el monto actual en caja: ");
                    Accounting.setCash(scanner.nextDouble());

                }catch(InputMismatchException e){
                    e.printStackTrace();
                }

            }else {       //the day changes
                Accounting.expensesToPayOrAddingInCurrentAccountFile(Accounting.getCash()-5000,2); //send amount in cash (-5000$) to current account array file
                Accounting.setCash(5000); //we set cash to 5000$ for starting the new day

                if(today.substring(5, today.length() - 3).equals(dateInFile.substring(5, dateInFile.length() - 3))){   ///the month changes


                    double totalMonthlyExpenses = Accounting.totalBillsToPayOrCurrentAccount(1);  //return total expenses of the ended month and sets to cero the billsToPay array
                    double totalMonthlyIncomes = Accounting.totalBillsToPayOrCurrentAccount(2);   //return total incomes of the ended month and sets to cero the currentAccount array
                    double monthlyBalance = totalMonthlyIncomes - totalMonthlyExpenses;

                    StringBuilder builder = new StringBuilder(1);    //building the monthlyBalance string
                    builder.append("------------------------------------------------------------\nPeriodo: ");
                    builder.append( dateInFile.substring(0,dateInFile.length()-3));
                    builder.append(".\nTotal ingresos: $");
                    builder.append(totalMonthlyIncomes);
                    builder.append(".\nTotal Egresos: $");
                    builder.append(totalMonthlyExpenses);
                    builder.append(".\nBalance mensual: $");
                    builder.append(monthlyBalance);
                    builder.append("\n------------------------------------------------------------\n");

                    String balance = "";
                    balance += builder;

                    Accounting.monthlyBalanceFileWriting(balance);  //sending it into a file

                }

            }
        }

        todayFileWriter(today);  //actualizing the day if the day has changed or overwriting if not

    }




    public   boolean checkingTodayFileContent(){
        //reads file  today.json and checks if there is info .
        // yes: returns true and puts in dateInFile.
        // No: returns false

        boolean flag = true;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(new File(filename)));
            this.dateInFile = gson.fromJson(reader, String.class);

        }catch(FileNotFoundException e){
            System.out.println("Archivo no existe");
            flag = false;                                   //file doesnt exist
        }catch(Exception e){
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
        return flag;

    }




    public  void  todayFileWriter(String today){

        //todayFileReader( );

        dateInFile = today;


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try{

            fSalida = new BufferedWriter(new FileWriter(new File( filename)));
            String json = gson.toJson(dateInFile,dateInFile.getClass());
            // System.out.println( "soy el string jason de monthly_blance \n " + json);
            fSalida.write(json);

        }catch(FileNotFoundException e) {
            System.out.println("Creando archivo ");
        }catch(Exception e){
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
    }



    /*

    public   void todayFileReader(){
        //reads file  today.json

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(new File(filename)));
            this.dateInFile = gson.fromJson(reader, String.class);

        }catch(FileNotFoundException e){
            System.out.println("Archivo no existe");

        }catch(Exception e){
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

    */
}


