package com.company.Accounting;

import com.company.Product.Beverage;
import com.company.RawMaterial.RawMaterial;
import com.company.persona.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Expenses2 extends Accounting {

    private Beverage beverage;
    private RawMaterial rawMat;
    private Employee employee;

    private int quantity;

    private  static List<Expenses2> expensesArray = new ArrayList<>();


    //region CONSTRUCT

    public Expenses2() {
        super();
    }

    public Expenses2(Beverage beb,int quantity ) {
        super();
        this.beverage = beb;
        this.quantity = quantity;
        expenseToBillsToPay(this);  //manda al arreglo bills to pay el monto del gasto
        expensesFile(this);
    }

    public Expenses2(RawMaterial rawMat, int quantity) {
        super();
        this.rawMat = rawMat;
        this.quantity = quantity;
        expenseToBillsToPay(this);
        expensesFile(this);
    }

    public Expenses2(Employee employee,int quantity) {
        super();
        this.employee = employee;
        this.quantity = quantity;
        expenseToBillsToPay(this);
        expensesFile(this);
    }

    //endregion



    //region getter y setter



    ///endregion




    public  static String createFileName() {     // adds year and month to "expenses-"
        // when a new month begins it will create a new file and the last one will be
        LocalDate date = LocalDate.now();
        String begins = "expenses-";

        begins += date;
        String filename =  begins.substring(0, begins.length() - 3);
        filename += ".json";


        return filename;
    }



    public void expenseToBillsToPay(Expenses2 exp){
        double expense = 0;
        if(exp.beverage != null){
            expense = exp.quantity * exp.beverage.getCostPrice();
        }else if (exp.rawMat != null){
            expense = exp.rawMat.getPrice() * exp.quantity;
        }else{
            expense = exp.employee.getWage();
        }

        Accounting.expensesToPayFile(expense);    //le paso al metodo de la clase Accounts el total para que lo agregue al archivo del arreglo billsToPay(double)

    }


    public static double printExpensesOneEmployee(Expenses2 xp){

        System.out.print("Comercio:          " + xp.COMPANYNAME);
        System.out.println( ". Cuit: " + xp .CUITNUMBER);
        System.out.println("ID empleado: " + xp.employee.getId());
        System.out.println("Nombre: " + xp.employee.getName());
        System.out.println("Apellido: " + xp.employee.getLastname());
        System.out.println("DNI: " + xp.employee.getDni());
        System.out.println("Salario: " + xp.employee.getWage());
        System.out.println("-----------------------------------------------------");

        return xp.employee.getWage();

    }

    public static  double mostrarGastoUnaBebida(Expenses2 xp){
        double total = 0;

        System.out.print("Comercio:          " + xp.COMPANYNAME);
        System.out.println( ". Cuit: " + xp .CUITNUMBER);
        System.out.println("ID producto:          " + xp.beverage.getId());
        System.out.println("Fecha:             " + xp.date);
        System.out.println("Nombre:          " + xp.beverage.getName());
        System.out.println("Marca:          " + xp.beverage.getBrand());
        System.out.println("Tamaño:          " + xp.beverage.getSizeInLt());
        System.out.println("Precio (x unidad): " + xp.beverage.getCostPrice());
        System.out.println("Cantidad:          " + xp.quantity);

        System.out.println("                             Total: " + xp.beverage.getCostPrice() * xp.quantity);
        System.out.println("-----------------------------------------------------------------");

        total = xp.beverage.getCostPrice() * xp.quantity;

        return total;
    }


    public static double mostrarGastoUnaMateriaPrima(Expenses2 xp){
        double total = 0;

        System.out.print("Comercio        : " + xp.COMPANYNAME);
        System.out.println( ". Cuit: " + xp .CUITNUMBER);
        System.out.println("Fecha           : " + xp.date);
        System.out.println("Nombre        : " + xp.rawMat.getName());
        System.out.println("Precio (x Kg)   : " + xp.rawMat.getPrice());
        System.out.println("Cantidad (en Kg): " + xp.quantity);

        System.out.println("                        Total: " + xp.rawMat.getPrice() * xp.quantity);
        System.out.println("-----------------------------------------------------------------");

        total = xp.rawMat.getPrice() * xp.quantity;

        return total;
    }


    public static void mostrarGastos( int option){
        double total = 0;
        double aux = 0;

        if(option == 0){
            System.out.println("\n\n\t\tGASTOS EN GRAL");
            System.out.println("-----------------------------------------------------------------");
            for(Expenses2 xp : expensesArray){
                if(xp != null){
                    if(xp.beverage != null){

                        aux = mostrarGastoUnaBebida(xp);

                    }else if (xp.rawMat != null) {
                        aux = mostrarGastoUnaMateriaPrima(xp);
                    }else
                        aux = printExpensesOneEmployee(xp);

                }
                total += aux;
            }
            System.out.println("Total hasta la fecha: " + total);

        }else if(option == 1){
            mostrarGastosBebidas();
        }else if (option == 2){
            mostrarGastosMateriasPrimas();
        }else{
            printEmployeeExpenses();
        }


    }


    public static void printEmployeeExpenses() {

        double total = 0;
        double aux = 0;

        System.out.println("\n\n\t\tGASTOS EN EMPLEADOS");
        System.out.println("-----------------------------------------------------------------");
        for(Expenses2 xp : expensesArray){
            if(xp.employee != null){

                aux = printExpensesOneEmployee(xp);
                total += aux;
            }

        }
        System.out.println("Total hasta la fecha: " + total);

    }


    public static void mostrarGastosMateriasPrimas() {

        double total = 0;
        double aux = 0;

        System.out.println("\n\n\t\tGASTOS EN MATERIAS PRIMAS");
        System.out.println("-----------------------------------------------------------------");
        for(Expenses2 xp : expensesArray){
            if(xp.rawMat != null){

                aux = mostrarGastoUnaMateriaPrima(xp);
                total += aux;
            }

        }
        System.out.println("Total hasta la fecha: " + total);

    }


    public static void mostrarGastosBebidas() {

        double total = 0;
        double aux = 0;

        System.out.println("GASTOS EN BEBIDAS");
        System.out.println("-----------------------------------------------------------------");
        for(Expenses2 xp : expensesArray) {
            if (xp.beverage != null) {
                aux = mostrarGastoUnaBebida(xp);
                total = total + aux;
            }

        }
        System.out.println("Total hasta la fecha: " + total);

    }


    @Override
    public String toString() {
        return "Expenses2{" +
                "COMPANYNAME='" + COMPANYNAME + '\'' +
                ", CUITNUMBER='" + CUITNUMBER + '\'' +
                ", date='" + date + '\'' +
                ", beverage=" + beverage +
                ", rawMat=" + rawMat +
                ", employee=" + employee +
                ", quantity=" + quantity +
                '}';
    }


    public static void expensesFile(Expenses2 expense){
        //creates a name for the file ,goes to Filehandling and opens file,
        // adds the expense to the expensesarray

        String filename = createFileName();

        expensesArray = FileHandling.writingListFile(expensesArray,filename,expense);
    }






    public static void printFileExpenses(String filename, int option){ //filename is in the parameter because of the historic expenses,
        ///option: 0 prints all expenses. 1 print only beverages. 2 only raw material


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File(filename)));
            expensesArray = gson.fromJson(reader,new TypeToken<List<Expenses2>>(){}.getType());

            mostrarGastos(option);     ///print content of  expenses

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

