package com.company.Accounting;

import com.company.Product.Product;
import com.company.pedidos.Delivery;
import com.company.pedidos.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Incomes extends Accounting {

    private Order order;


    private static List<Incomes> incomesArray = new ArrayList<>();



    //region Construct
    public Incomes(){
        super();
    }

    public Incomes(Order order) {
        super();
        this.order = order;
        totalToCash();
        ticketsFile(this);

    }

    //endregion

    //region getter y setter




    //endregion


    public void  totalToCash(){

        Accounting.setCash( getCash() + order.getFinalPrice());
    }



    public  static String createFileName() {     // adds year and month to "tickets-"
        // when a new month begins it will create a new file
        LocalDate date = LocalDate.now();
        String begins = "tickets-";


        begins += date;
        String filename =  begins.substring(0, begins.length() - 3);
        filename += ".json";


        return filename;
    }


    public static void printIncomeOneTicket(Incomes inc){

        double total = 0;

        System.out.print("Comercio:          " + inc.COMPANYNAME);
        System.out.println( ". Cuit: " + inc .CUITNUMBER);
        System.out.println("Fecha: " + inc.date);
        System.out.println( "ID orden: " + inc.order);
        System.out.println("Nombre Cliente: " + inc.order.getClient().getName() + "" + inc.order.getClient().getLastname());
        System.out.println("Direccion: " + inc.order.getClient().getAddress());
        System.out.println("Telefono: " + inc.order.getClient().getTelNumber());


        System.out.println("\n pedidos solicitados: ");

        for(Product mylist : inc.order.getProducts()){
            if (inc!= null){
                System.out.println(mylist);
            }
        }

        if(inc.order.getFinalPrice() != inc.order.getTotalPrice()){
            System.out.println("Costo delivery: " + (inc.order.getTotalPrice() - inc.order.getFinalPrice()));
        }

        System.out.println("Total a pagar = $" +  inc.order.getFinalPrice());
        System.out.println("-----------------------------------------------------");


    }


    public static  void printTickets() {

        System.out.println("\n\n\t\tTickets del mes");
        System.out.println("-----------------------------------------------------------------");
        for(Incomes inc : incomesArray){
            if(inc != null){

                printIncomeOneTicket(inc);
            }

        }
    }


    public static String creatingFileName(){

        return AccountHandler.createFileName("tickets-");
    }


    public  void  ticketsFile(Incomes income){

        //sobreescribe archivo con el expensesArray (donde estan todos los ingresos)

        String filename = creatingFileName();

        AccountHandler.filenameToFilenameArray(filename,fileNameArray);

        incomesArray = AccountHandler.writingListFile(incomesArray,filename,income);


    }

/*
    public  void  ticketsFile(Incomes income){

        //sobreescribe archivo con el expensesArray (donde estan todos los ingresos)

        String filename = createFileName();

        incomesArray = FileHandling.writingListFile(incomesArray,filename,income);


    }

*/




    public static void printFileTickets(String filename){

        //filename is in the parameter because of the historic expenses,


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            incomesArray = gson.fromJson(reader,new TypeToken<List<Incomes>>(){}.getType());


            printTickets();     ///print content of  incomes

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

    public static void printFileWithExpensesAndTicketNames(){

        AccountHandler.printFilenameFile(fileNameArray,"tic");

    }


}

