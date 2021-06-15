package com.company.Accounting;

import com.company.Product.Beverage;
import com.company.RawMaterial.RawMaterial;
import com.company.Person.Employee;
import com.company.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Expenses extends Accounting {

    private Beverage beverage;
    private RawMaterial rawMat;
    private Employee employee;

    private int quantity;

    private static List<Expenses> expensesArray = new ArrayList<>();

    // region CONSTRUCTOR

    public Expenses() {
        super();
    }

    public Expenses(Beverage beb, int quantity) {
        super();
        this.beverage = beb;
        this.quantity = quantity;
        expenseToBillsToPay(this); // manda al arreglo bills to pay el monto del gasto
        expensesFile(this);
    }

    public Expenses(RawMaterial rawMat, int quantity) {
        super();
        this.rawMat = rawMat;
        this.quantity = quantity;
        expenseToBillsToPay(this);
        expensesFile(this);
    }

    public Expenses(Employee employee) {
        super();
        this.employee = employee;
        expenseToBillsToPay(this);
        expensesFile(this);
    }

    // endregion

    // region GETTER & SETTER

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public RawMaterial getRawMat() {
        return rawMat;
    }

    public void setRawMat(RawMaterial rawMat) {
        this.rawMat = rawMat;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static List<Expenses> getExpensesArray() {
        return expensesArray;
    }

    public static void setExpensesArray(List<Expenses> expensesArray) {
        Expenses.expensesArray = expensesArray;
    }

    // endregion

    public static String creatingFileName() {
        // creates the file name concatenating expenses- with localdate except day
        return AccountHandler.createFileName("expenses-");
    }

    public void expenseToBillsToPay(Expenses exp) {
        // finds out about wich objet is the expense (exp) and send the
        // total expense to billsToPay array, in Accounting class

        double expense = 0;
        if (exp.beverage != null) {
            expense = exp.quantity * exp.beverage.getCostPrice();
        } else if (exp.rawMat != null) {
            expense = exp.rawMat.getPrice() * exp.quantity;
        } else {
            expense = exp.employee.getWage();
        }

        Accounting.expensesToPayOrAddingInCurrentAccountFile(expense, 1); // le paso al metodo de la clase Accounts el
                                                                          // total para que lo agregue al archivo del
                                                                          // arreglo billsToPay(double)

    }

    public static double printExpensesOneEmployee(Expenses xp) {

        System.out.print("Comercio:          " + xp.COMPANYNAME);
        System.out.println(". Cuit: " + xp.CUITNUMBER);
        System.out.println("ID empleado: " + xp.employee.getId());
        System.out.println("Nombre: " + xp.employee.getName());
        System.out.println("Apellido: " + xp.employee.getLastname());
        System.out.println("DNI: " + xp.employee.getDni());
        System.out.println("Salario: " + xp.employee.getWage());
        System.out.println("-----------------------------------------------------");

        return xp.employee.getWage();

    }

    public static double oneBeverageExpense(Expenses xp) {
        double total = 0;

        System.out.print("Comercio:          " + xp.COMPANYNAME);
        System.out.println(". Cuit: " + xp.CUITNUMBER);
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

    public static double oneRawMaterialExpense(Expenses xp) {
        double total = 0;

        System.out.print("Comercio        : " + xp.COMPANYNAME);
        System.out.println(". Cuit: " + xp.CUITNUMBER);
        System.out.println("Fecha           : " + xp.date);
        System.out.println("Nombre        : " + xp.rawMat.getName());
        System.out.println("Precio (x Kg)   : " + xp.rawMat.getPrice());
        System.out.println("Cantidad (en Kg): " + xp.quantity);

        System.out.println("                        Total: " + xp.rawMat.getPrice() * xp.quantity);
        System.out.println("-----------------------------------------------------------------");

        total = xp.rawMat.getPrice() * xp.quantity;

        return total;
    }

    public static void printExpenses(int option) {
        /// option 0 = all expenses. 1: just beverages. 2: just rawMaterial. 3: just
        /// employee

        double total = 0;
        double aux = 0;
        Utils.cls();
        if (option == 0) {
            System.out.println("\n\n\t\tGASTOS EN GRAL");
            System.out.println("-----------------------------------------------------------------");
            for (Expenses xp : expensesArray) {
                if (xp != null) {
                    if (xp.beverage != null) {
                        aux = oneBeverageExpense(xp);
                    } else if (xp.rawMat != null) {
                        aux = oneRawMaterialExpense(xp);
                    } else
                        aux = printExpensesOneEmployee(xp);

                }
                total += aux;
            }
            System.out.println("Total hasta la fecha: " + total);

        } else if (option == 1) {
            printBeverageExpenses();
        } else if (option == 2) {
            printRawMaterialExpenses();
        } else {
            printEmployeeExpenses();
        }
        Utils.pressToContinue();

    }

    public static void printEmployeeExpenses() {

        double total = 0;
        double aux = 0;

        System.out.println("\n\n\t\tGASTOS EN EMPLEADOS");
        System.out.println("-----------------------------------------------------------------");
        for (Expenses xp : expensesArray) {
            if (xp.employee != null) {

                aux = printExpensesOneEmployee(xp);
                total += aux;
            }

        }
        System.out.println("Total hasta la fecha: " + total);

    }

    public static void printRawMaterialExpenses() {

        double total = 0;
        double aux = 0;

        System.out.println("\n\n\t\tGASTOS EN MATERIAS PRIMAS");
        System.out.println("-----------------------------------------------------------------");
        for (Expenses xp : expensesArray) {
            if (xp.rawMat != null) {

                aux = oneRawMaterialExpense(xp);
                total += aux;
            }

        }
        System.out.println("Total hasta la fecha: " + total);

    }

    public static void printBeverageExpenses() {

        double total = 0;
        double aux = 0;

        System.out.println("GASTOS EN BEBIDAS");
        System.out.println("-----------------------------------------------------------------");
        for (Expenses xp : expensesArray) {
            if (xp.beverage != null) {
                aux = oneBeverageExpense(xp);
                total = total + aux;
            }

        }
        System.out.println("Total hasta la fecha: " + total);

    }

    @Override
    public String toString() {
        return "Expenses2{" + "COMPANYNAME='" + COMPANYNAME + '\'' + ", CUITNUMBER='" + CUITNUMBER + '\'' + ", date='"
                + date + '\'' + ", beverage=" + beverage + ", rawMat=" + rawMat + ", employee=" + employee
                + ", quantity=" + quantity + '}';
    }

    public void expensesFile(Expenses expense) {
        // creates filename and puts it in a file(filename.json).
        // adds expense in expensesArray

        String filename = creatingFileName();

        AccountHandler.filenameToFilenameArray(filename, fileNameArray); // adds filename into filenameArray (if doesnt
                                                                         // exist)

        expensesArray = AccountHandler.writingListFile(expensesArray, filename, expense); // generic method

    }

    public static void printFileExpenses(String filename, int option) {
        // filename is in the parameter because of the historic expenses,
        /// option: 0 prints all expenses. 1 print only beverages. 2 only raw material.
        // 3: employees

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;
        File file = new File(filename);
        if (file.exists()) {
            try {
                reader = new BufferedReader(new FileReader(file));
                expensesArray = gson.fromJson(reader, new TypeToken<List<Expenses>>() {
                }.getType());
                printExpenses(option); /// print content of expenses
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
            System.out.println("No hay ningun gasto ingresado");
            Utils.pressToContinue();
        }
    }

    public static void printFileWithExpensesAndTicketNames() {
        // prints the filenames.json string array (contains all the files names for
        // expenses and for incomes(tickets))

        AccountHandler.printFilenameFile(fileNameArray, "exp");

    }

}
