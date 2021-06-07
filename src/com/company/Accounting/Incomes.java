package com.company.Accounting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Incomes extends Accounts {

    private Pedidos pedidos;
    // private Bebidas bebidas;
    //private Manufacturas manufacturas;

    private static List<Incomes> incomesArray = new ArrayList<>();



    //region Construct
    public Incomes(){
        super();
    }

    public Incomes(Pedidos pedidos) {
        super();
        this.pedidos = pedidos;
        totalToCash();                //
        ticketsFile(this);

    }

    //endregion

    //region getter y setter

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public static List<Incomes> getIngresos() {
        return incomesArray;
    }

    public static void setIngresos(List<Incomes> ingresos) {
        incomesArray = ingresos;
    }


    //endregion


    public void  totalToCash(){
        double total = 0;
        if(pedidos.isDelivery()){
            total += 80;
        }
        total += pedidos.getTotalAPagar();
        Accounts.setCash( getCash() + total);
    }



    public  static String createFileName() {     // adds year and month to "tickets-"
        // when a new month begins it will create a new file and the last one will be
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
        System.out.println("Nombre: " + inc.pedidos.getApenom());
        System.out.println("Direccion: " + inc.pedidos.getDireccion());
        System.out.println("Telefono: " + inc.pedidos.getTel());

        System.out.println("\nHash pedidos hechos: ");
        for(Integer arre : inc.pedidos.getArregloCodigoProdPedidos()){
            if (arre != null){
                System.out.println(arre);
            }
        }
        System.out.println("Delivery: " + inc.pedidos.isDelivery());

        if(inc.pedidos.isDelivery() ){
            total += 80;
        }
        System.out.println("Total a pagar = $" +  (total += inc.pedidos.getTotalAPagar()));
        System.out.println("-----------------------------------------------------");


    }


    public static  void mostrarTickets() {

        System.out.println("\n\n\t\tTickets del mes");
        System.out.println("-----------------------------------------------------------------");
        for(Incomes inc : incomesArray){
            if(inc != null){

                printIncomeOneTicket(inc);
            }

        }
    }





    public  void  ticketsFile(Incomes income){

        //sobreescribe archivo con el expensesArray (donde estan todos los ingresos)

        String filename = createFileName();

        incomesArray = FileHandling.writingListFile(incomesArray,filename,income);


    }










    public static void printFileTickets(String filename){

        //filename is in the parameter because of the historic expenses,


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            incomesArray = gson.fromJson(reader,new TypeToken<List<Incomes>>(){}.getType());


            mostrarTickets();     ///print content of  incomes

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

