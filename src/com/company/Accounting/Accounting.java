package com.company.Accounting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public  class Accounting {


    final String COMPANYNAME = "Pizzeria el programador";
    final String CUITNUMBER = "30-23985345-3";


    protected  String date;

    private static double cash;


    private static double [] currentAccount = new double[100];
    private  static double [] billsToPay = new  double[100];

    protected static String[] fileNameArray = new  String[50];

    private static String[]monthlyBalance = new String[50];


    //region Construct

    public Accounting() {
        this.date = LocalDatetoString();
    }

    //endregion



    //region Getter Y Setter

    public static double getCash() {
        return gettingCash();
    }  // reads cash.json file and returns

    public static void setCash(double cash) {
        settingCash(cash);;
    }

    public static String[] getMonthlyBalance() {
        return monthlyBalance;
    }

    public static void setMonthlyBalance(String[] monthlyBalance) {
        Accounting.monthlyBalance = monthlyBalance;
    }

    public double[] getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(double[] currentAccount) {
        Accounting.currentAccount = currentAccount;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static double[] getBillsToPay() {
        return billsToPay;
    }

    public static void setBillsToPay(double[] billsToPay) {
        Accounting.billsToPay = billsToPay;
    }

    public static String[] getFileNameArray() {
        return fileNameArray;
    }

    public static void setFileNameArray(String[] fileNameArray) {
        Accounting.fileNameArray = fileNameArray;
    }

    //endregion




    public String LocalDatetoString(){
        LocalDateTime date = LocalDateTime.now();
        String aux = "";

        aux += date;
        return aux;
    }



    public static double gettingCash(){
        //reads file  cash.json

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("cash.json")));
            cash = gson.fromJson(reader,new TypeToken<String[]>(){}.getType());

        }catch(FileNotFoundException e) {
            System.out.println("creando archivo");
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

        return cash;

    }

    public static void settingCash(double amount){
        //rewrite file  cash.json

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try{

            fSalida = new BufferedWriter(new FileWriter(new File( "cash.json")));
            String json = gson.toJson(cash);
            // System.out.println( "soy el string jason de monthly_blance \n " + json);
            fSalida.write(json);

        }catch(FileNotFoundException e) {
            System.out.println("Archivo no existe ");
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





    public static void  amountToBillsToPayOrCurrentAccount(double monto,int option){
        //adds amount in billsToPay array or in currentAccount array
        //option1=billsToPay   option2 = currentAccount

        int i = 0;

        if(option == 1){
            while(i < billsToPay.length){
                if(billsToPay[i] == 0){
                    billsToPay[i] = monto;
                    break;
                }
                i++;
            }
        }else{
            while(i < currentAccount.length){
                if(currentAccount[i] == 0){
                    currentAccount[i] = monto;
                    break;
                }
                i++;
            }

        }

    }



    public static void printsBillsToPayOrCurrentAccount(int option){

        //option 1 = billsToPay .. option 2 = currentAccount

        double total = 0;

        if(option == 1){
            System.out.println("Cuentas a pagar hasta la fecha\n-------------------------------");
            for (double btp : billsToPay) {
                if(btp != 0){
                    System.out.println("\t\t\t" + btp + "$");
                    total += btp;

                }
            }
            System.out.println("-------------------------------\n" + "\tTotal: \t" +  total + "$\n");

        }else{

            System.out.println("Cierres de caja hasta la fecha\n-------------------------------");
            for (double ca : currentAccount) {
                if(ca != 0){
                    System.out.println("\t\t\t" + ca + "$");
                    total += ca;

                }
            }
            System.out.println("-------------------------------\n" + "\tTotal: \t" +  total + "$\n");
        }



    }



/*
    public void pedidotoCaja(double monto){
        cash += monto;
    }

    public String LocalDatetoString(){
        LocalDateTime date = LocalDateTime.now();
        String aux = "";

        aux += date;
        return aux;
    }
*/

    public static void printCash(){
        System.out.println("Total en caja: " + getCash());
    }




    public  static void expensesToPayOrAddingInCurrentAccountFileToArray(String filename,int option){
        //lee el archivo  bills_to_pay.json  o y pasa su contenido a expensesArray para no perder
        // los datos ya que  despues el arreglo siempre sobreescribe el archivo


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));

            if (option == 1){
                billsToPay = gson.fromJson(reader, billsToPay.getClass());
            }else{
                currentAccount = gson.fromJson(reader, currentAccount.getClass());
            }


        }catch(FileNotFoundException e) {
            System.out.println("Archivo no existe pero se creara: " + filename);
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






    public  static void  expensesToPayOrAddingInCurrentAccountFile(double amount,int option){
        //sobreescribe archivo con el arreglo billsToPay o currentAccount (donde estan todos los gastos (double) o los ingresos)

        String filename;

        if(option == 1){
             filename = "bills-to-pay.json";
        }else{
            filename = "current-account.json";
        }


        expensesToPayOrAddingInCurrentAccountFileToArray(filename,option);
        amountToBillsToPayOrCurrentAccount(amount,option);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try {

            fSalida = new BufferedWriter(new FileWriter(new File(filename)));

            String json;

            if (option == 1) {
                json = gson.toJson(billsToPay, billsToPay.getClass());
                //System.out.println( "soy el string jason \n " + json);
            } else {
                json = gson.toJson(currentAccount, currentAccount.getClass());
                //System.out.println( "soy el string jason \n " + json);
            }

            fSalida.write(json);

        }catch(FileNotFoundException e){
            System.out.println("Archivo no existe");
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





    public static void printFileBillsToPayOrCurrentAccount(int option){
        //filename is in the parameter because of the historic expenses,
        ///option: 0 prints all expenses. 1 print only beverages. 2 only raw material

        String filename;

        if(option == 1){
            filename = "bills-to-pay.json";
        }else{
            filename = "current-account.json";
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            if(option == 1){
                billsToPay = gson.fromJson(reader,billsToPay.getClass());
            }else{
                currentAccount = gson.fromJson(reader,currentAccount.getClass());
            }


            printsBillsToPayOrCurrentAccount(option);    ///print content of  expenses

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



    public static double totalBillsToPayOrCurrentAccount(int option){ // 1 returns total billsToPay and delete. 2 currentAccount

        double total = 0;

        String filename;

        if(option == 1){
            filename = "bills-to-pay.json";
        }else{
            filename = "current-account.json";
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            if(option == 1){
                billsToPay = gson.fromJson(reader,billsToPay.getClass());
            }else{
                currentAccount = gson.fromJson(reader,currentAccount.getClass());
            }

            total = returningTotalAndDeletingBillsToPayOrCurrentAccount(option);



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

        return total;
    }

    public static double returningTotalAndDeletingBillsToPayOrCurrentAccount(int option){

        double total = 0;

        if(option == 1){

            for (double btp : billsToPay) {
                if(btp != 0){
                    total += btp;
                    btp = 0;                  //una vez que ya agregue al total el gasto, asigno cero(que es como si lo borrara) xq esta funcion solo se llama al finalizar el mes
                }
            }

        }else{

            for (double ca : currentAccount) {
                if(ca != 0){
                    total += ca;
                    ca = 0;                 //una vez que ya agregue al total el cierre de caja, asigno cero(que es como si lo borrara)xq esta funcion solo se llama al finalizar el mes

                }
            }
        }

        return total;

    }





    public  static void monthlyBalanceFileRead(String filename){
        //reads file  monthlyBalance.json

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            monthlyBalance = gson.fromJson(reader,new TypeToken<String[]>(){}.getType());

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

    }


    public static void  monthlyBalanceFileWriting(String data){

        String filename = "monthly-balance.json";

        monthlyBalanceFileRead(filename );


        for(String mb : monthlyBalance){
            if( mb == null ){
                mb = data;
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try{

            fSalida = new BufferedWriter(new FileWriter(new File( filename)));
            String json = gson.toJson(monthlyBalance,monthlyBalance.getClass());
            // System.out.println( "soy el string jason de monthly_blance \n " + json);
            fSalida.write(json);

        }catch(IOException e){
            System.out.println("Creando archivo ");
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



    public  static void printMonthlyBalance(String filename){
        //reads file  monthlyBalance.json

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            monthlyBalance = gson.fromJson(reader,new TypeToken<String[]>(){}.getType());

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

    }



}

