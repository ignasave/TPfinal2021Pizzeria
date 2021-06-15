package com.company.Accounting;

import com.company.Utils.Utils;

public class AccountingController {
    public AccountingController() {
    }


    public static void expensesMenu () {
        boolean out = false;
        int option;
        while (!out) {
            Utils.cls();
            System.out.println("«1. Totales»");
            System.out.println("«2. Bebidas»");
            System.out.println("«3. Materia prima»");
            System.out.println("«4. Empleados»");
            System.out.println("«9. Cerrar»");
            System.out.println("«Escribe una de las opciones»");
            option = Utils.readInt();
            switch (option) {
                case 1, 2, 3, 4:
                    Expenses.printFileExpenses(Expenses.creatingFileName(),option - 1);
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }

        }
    }

    public static void accountingMenu () {
        boolean out = false;
        int option;
        while (!out) {
            Utils.cls();
            System.out.println("«1. Gastos»");
            System.out.println("«2. Tickets»");
            System.out.println("«3. Caja»");
            System.out.println("«4. Cuenta Corriente»");
            System.out.println("«5. Cuentas a pagar»");
            System.out.println("«6. Balances Mensuales»");
            System.out.println("«9. Cerrar»");
            System.out.println("«Escribe una de las opciones»");
            option = Utils.readInt();
            switch (option) {
                case 1:
                    expensesMenu();
                    break;
                case 2:
                    Incomes.printFileTickets(Incomes.creatingFileName());
                    break;
                case 3:
                    Utils.cls();
                    System.out.println("Dinero en caja:");
                    System.out.println(Accounting.getCash());
                    Utils.pressToContinue();
                    break;
                case 4:
                    Accounting.printFileBillsToPayOrCurrentAccount(2);
                    break;
                case 5:
                    Accounting.printFileBillsToPayOrCurrentAccount(1);
                    break;
                case 6:
                    Accounting.printMonthlyBalance("monthly-balance.json");
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }

        }
    }
}
