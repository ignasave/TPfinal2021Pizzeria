package com.company.Person;

import com.company.Utils.Utils;

import java.util.Locale;
import java.util.UUID;

public class Employee extends Person {

    private float wage;
    private boolean active = true;
    private int dni;
    private String id;
    private boolean extern;

    //region CONSTRUCTORS
    public Employee() {
    }


    public Employee(String name, String lastname, float wage, boolean active, int dni, boolean extern) {
        super(name, lastname);
        this.wage = wage;
        this.active = active;
        this.dni = dni;
        this.id = Utils.generateUniqueID();
        this.extern = extern;

    }

    //endregion

    //region GETTER & SETTER

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getId() {
        return this.id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    //endregion

    //region HELPERS
    @Override
    public String toString() {
        return super.toString() +
                "\nWage: " + getWage();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Employee))
            return false;

        Employee employee = (Employee) o;
        boolean answer = super.equals(o) && this.dni == employee.getDni();

        return answer;
    }

    @Override
    public int hashCode() {
        int answer = super.hashCode();
        answer += 31 * Integer.hashCode(this.dni);
        return answer;
    }

    //endregion












    /*

    public class Employee extends Person{

    private float wage;
    private boolean active ;
    private int dni;
    private String id;

    private static List<Employee> employeeArray = new ArrayList<>();


    //region CONSTRUCTORS
    public Employee(){}


    public Employee(String name, String lastname, float wage, int dni) {
        super(name, lastname);
        this.wage = wage;
        this.active = true;
        this.dni = dni;
        this.id= UUID.randomUUID().toString().toUpperCase(Locale.ROOT).substring(0,13);

        employeeToFileArray(this);

    }

    //endregion

    //region GETTER & SETTER



    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public float getWage() {return wage;}
    public void setWage(float wage) {this.wage = wage; }

    public String getId(){return this.id;}

    public int getDni (){return dni;}
    public void setDni (int dni){this.dni = dni;}

    //endregion

    //region HELPERS
    @Override
    public String toString(){
        return super.toString() +
                "\nWage: " + getWage();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Employee))
            return false;

        Employee employee = (Employee) o;
        boolean answer = super.equals(o) && this.dni == employee.getDni();

        return answer;
    }

    @Override
    public int hashCode() {
        int answer = super.hashCode();
        answer += 31* Integer.hashCode(this.dni);
        return answer;
    }

    //endregion




    public  static void fileToArrayOfEmployee(){
        //lee el archivo  employee.json y pasa su contenido a employeeArray para no perder
        // los datos ya que  despues el arreglo siempre sobreescribe el archivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("employee.json")));
            employeeArray = gson.fromJson(reader,new TypeToken<List<Employee>>(){}.getType());

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


    public  void  employeeToFileArray(Employee employee){   //sobreescribe archivo con el employeeArray (donde estan todos los empleados)

        fileToArrayOfEmployee();
        employeeArray.add(employee);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try{

            fSalida = new BufferedWriter(new FileWriter(new File( "employee.json")));
            String json = gson.toJson(employeeArray,employeeArray.getClass());
            System.out.println( "soy el string jason de employee \n " + json);
            fSalida.write(json);

        }catch(IOException e){
            System.out.println("Creando archivo employee.json");
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

    public static void printFileArrayEmployee(){  ///abre archivo employeeArray , lee su contenido y printea
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("employee.json")));
            employeeArray = gson.fromJson(reader,new TypeToken<List<Employee>>(){}.getType());

            System.out.println("Soy archivo employee\n--------------------------------------------");
            for(Employee empl: employeeArray){
                if(empl != null ){
                    System.out.println("ID empleado: " + empl.id);
                    System.out.println("Nombre: " + empl.firstName);
                    System.out.println("Apellido: " + empl.lastName);
                    System.out.println("DNI: " + empl.dni);
                    System.out.println("Activo?: " + empl.active);
                    System.out.println("Salario: " + empl.wage);
                    System.out.println("-----------------------------------------------------");
                }
            }

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


    public void employeeToExpenses(){   ///once a month sends the active employees to Expenses

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("employee.json")));
            employeeArray = gson.fromJson(reader,new TypeToken<List<Employee>>(){}.getType());

            for(Employee empl: employeeArray){
                if(empl != null && empl.active ){   //arraylist have all time  employees, the diference is if they are active or not. we send to expenses only the active employee

                    Expenses2 exp = new Expenses2(empl);

                }
            }

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
     */



}
