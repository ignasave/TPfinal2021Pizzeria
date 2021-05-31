package com.company.Accounting;

import java.time.LocalDateTime;

public class Accounting {
    final String COMPANYNAME = "Pizzeria el programador";
    final String CUITNUMBER = "30-23985345-3";

    //protected LocalDateTime date ;

    protected  String date;

    private static double cash;
    private double cashclose;

    private static double [] cuentaCorriente = new double[100];
    private  static double [] cuentasAPagar = new  double[100];


    //region Construct

    public Accounting() {
        this.date = LocalDatetoString();
    }

    //endregion



    //region Getter Y Setter

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
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
        this.cuentaCorriente = cuentaCorriente;
    }

    public double[] getCuentasAPagar() {
        return cuentasAPagar;
    }

    public void setCuentasAPagar(double[] cuentasAPagar) {
        this.cuentasAPagar = cuentasAPagar;
    }

    //endregion

    public static void  expenseToBillsToPay(double monto){

        int i = 0;
        while(i < cuentasAPagar.length){
            if(cuentasAPagar[i] == 0){
                cuentasAPagar[i] = monto;
                break;
            }
            i++;
        }


    }

    public void mostrarCuentasAPagar(){

        System.out.println("Cuentas a pagar hasta la fecha\n-------------------------------");
        double total = 0;
        for (double v : cuentasAPagar) {
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
}
