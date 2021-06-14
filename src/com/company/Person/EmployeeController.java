package com.company.Person;

import com.company.Order.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private ArrayList<Employee> employee;


    public void readEmployeeFile(File nameFile, ArrayList<Employee> employeeList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nameFile));

            employeeList = gson.fromJson(reader, (new TypeToken<List<Employee>>() {
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


    public Employee getEmployeeDelivery() {
        Employee employee = new Employee();

        for (Employee employee2 : this.employee) {
            if (employee2.isExtern() && employee2.isActive())
                employee = employee2;
        }

        return employee;
    }


}

