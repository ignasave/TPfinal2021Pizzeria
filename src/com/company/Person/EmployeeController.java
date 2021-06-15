package com.company.Person;

import com.company.Order.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private ArrayList<Employee> employee = new ArrayList<>();

    public void EmployeeController() {
    }

    // region GETTER & SETTER
    public ArrayList<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<Employee> employee) {
        this.employee = employee;
    }
    // endregion

    // region FILE
    public void saveEmployee(String nameFile) {
        /// el gson ahora tiene formato mas facil de leer
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        /** guardando un archivo con informacion json */

        BufferedWriter fOut = null;

        try {
            fOut = new BufferedWriter(new FileWriter(new File(nameFile)));

            gson.toJson(this.employee, this.employee.getClass(), fOut);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (fOut != null) {
                try {
                    fOut.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readEmployeeFile(String nameFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nameFile));

            this.employee = gson.fromJson(reader, (new TypeToken<List<Employee>>() {
            }.getType()));

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
    }

    // endregion

    // region HELPERS
    public void showOneEmployee(Employee employee) {
        System.out.println("---------------------------------------\n");
        System.out.println("  Nombre: " + employee.getName());
        System.out.println("Apellido: " + employee.getLastname());
        System.out.println("     Dni: " + employee.getDni());
        System.out.println("      ID: " + employee.getId());
        System.out.println("  Sueldo: " + employee.getWage());
        if (employee.isActive())
            System.out.println("Activo");
        else
            System.out.println("Inactive");
        if (!employee.isExtern())
            System.out.println("Empleado Interno");
        else
            System.out.println("Delivery");
        System.out.println("\n---------------------------------------\n");
    }

    public void showEmployees() {
        this.employee.forEach((v) -> showOneEmployee(v));
    }

    public Employee getEmployeeDelivery() {
        Employee employee = new Employee();

        for (Employee employee2 : this.employee) {
            if (employee2.isExtern() && employee2.isActive())
                employee = employee2;
        }

        return employee;
    }
    // endregion

}
