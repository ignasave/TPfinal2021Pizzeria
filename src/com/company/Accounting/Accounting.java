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
    private double cashclose;

    private static double [] cuentaCorriente = new double[100];
    private  static double [] billsToPay = new  double[100];

    protected static String[] fileNameArray = new  String[50];


    //region Construct

    public Accounting() {
        this.date = LocalDatetoString();
    }

    //endregion



    //region Getter Y Setter

    public static double getCash() {
        return cash;
    }

    public static void setCash(double cash) {
        Accounting.cash = cash;
    }

    public double getCashclose() {
        return cashclose;
    }

    public void setCashclose(double cashclose) {
        this.cashclose = cashclose;
    }

    public double[] getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(double[] cuentaCorriente) {
        Accounting.cuentaCorriente = cuentaCorriente;
    }

    public double[] getCuentasAPagar() {
        return billsToPay;
    }

    public void setCuentasAPagar(double[] cuentasAPagar) {
        Accounting.billsToPay = cuentasAPagar;
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





    public static void  amountToBillsToPay(double monto){

        int i = 0;
        while(i < billsToPay.length){
            if(billsToPay[i] == 0){
                billsToPay[i] = monto;
                break;
            }
            i++;
        }
    }



    public static void mostrarCuentasAPagar(){

        System.out.println("Cuentas a pagar hasta la fecha\n-------------------------------");
        double total = 0;
        for (double v : billsToPay) {
            if(v != 0){
                System.out.println("\t\t\t" + v + "$");
                total += v;
            }
        }
        System.out.println("-------------------------------\n" + "\tTotal: \t" +  total + "$\n");

    }




    public void pedidotoCaja(double monto){
        cash += monto;
    }

    public String LocalDatetoString(){
        LocalDateTime date = LocalDateTime.now();
        String aux = "";

        aux += date;
        return aux;
    }


    public static void printCash(){
        System.out.println("Total en caja: " + getCash());
    }




    public  static void expensesToPayFileToArray(String filename){
        //lee el archivo  bills_to_pay.json y pasa su contenido a expensesArray para no perder
        // los datos ya que  despues el arreglo siempre sobreescribe el archivo
        //String filename = createFileName();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            billsToPay = gson.fromJson(reader, billsToPay.getClass());

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
    }






    public  static void  expensesToPayFile(double amount){
        //sobreescribe archivo con el arreglo billsToPay (donde estan todos los gastos (double))

        String filename = "bills-to-pay.json";

        expensesToPayFileToArray(filename);
        amountToBillsToPay(amount);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try{

            fSalida = new BufferedWriter(new FileWriter(new File( filename)));
            String json = gson.toJson(billsToPay,billsToPay.getClass());
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

    }





    public static void printFileExpenses(){ //filename is in the parameter because of the historic expenses,
        ///option: 0 prints all expenses. 1 print only beverages. 2 only raw material


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("bills-to-pay.json")));
            billsToPay = gson.fromJson(reader,billsToPay.getClass());

            mostrarCuentasAPagar();    ///print content of  expenses

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

