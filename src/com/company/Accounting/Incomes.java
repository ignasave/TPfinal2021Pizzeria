package com.company.Accounting;

import com.company.Product.Product;
import com.company.Order.Delivery;
import com.company.Order.Order;
import com.company.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static List<Incomes> getIncomesArray() {
        return incomesArray;
    }

    public static void setIncomesArray(List<Incomes> incomesArray) {
        Incomes.incomesArray = incomesArray;
    }


    //endregion





    public void  totalToCash(){
        //adds in cash the total income from the order

        Accounting.setCash( getCash() + order.getFinalPrice());
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
        Utils.cls();
        Scanner reader = new Scanner(System.in);
        System.out.println("\n\n\t\tTickets del mes");
        System.out.println("-----------------------------------------------------------------");
        for(Incomes inc : incomesArray){
            if(inc != null){
                printIncomeOneTicket(inc);
            }
        }
        System.out.println("Cualquiera para continuar");
        reader.nextLine();
    }


    public static String creatingFileName(){
        //creates the file name concatenating tickets with localdate except day

        return AccountHandler.createFileName("tickets-");
    }


    public  void  ticketsFile(Incomes income){

        //creates filename and puts it in a file(filename.json).
        //adds ticket(income) in  incomesArray

        String filename = creatingFileName();

        AccountHandler.filenameToFilenameArray(filename,fileNameArray);

        incomesArray = AccountHandler.writingListFile(incomesArray,filename,income); //generic method


    }




    public static void printFileTickets(String filename){
        //prints tickets in the tickets-......json file
        //filename is in the parameter because of the historic expenses,


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;
        File file = new File(filename);
        if(file.exists()) {
            try {
                reader = new BufferedReader(new FileReader(file));
                incomesArray = gson.fromJson(reader, new TypeToken<List<Incomes>>() {
                }.getType());
                printTickets();     ///print content of  incomes

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Utils.cls();
            System.out.println("No hay ningun ticket ingresado");
            Scanner sReader = new Scanner(System.in);
            System.out.println("Cualquiera para continuar");
            sReader.nextLine();
        }
    }

    public static void printFileWithExpensesAndTicketNames(){
        //print files names in the file filenames.json

        AccountHandler.printFilenameFile(fileNameArray,"tic");

    }


}

