package com.company.pedidos;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Product.Beverage;
import com.company.Product.Food;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.persona.Client;
import com.company.persona.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {


        ArrayList newListOfProducts = new ArrayList();
        newListOfProducts = selectProduct();


        System.out.println("------------------------------------\n\n");
        newListOfProducts.forEach((v)-> {
            if (v instanceof Food)
                ((Food) v).showFood();
            else if (v instanceof Beverage)
                System.out.println(v.toString());

        });

    }

    public static Food createFood (ArrayList<RawMaterial>materials,String name, String type, int price){
        Food newFood = new Food (name + type, price, price+150, name,
                type,materials);
        return newFood;
    }

    //region LISTRAWMATERIALS
    public static void createListRawMaterialEmp(ArrayList<RawMaterial>newList, String type){
        RawMaterial flour = new RawMaterial("Harina", 5);
        RawMaterial cheese = new RawMaterial("Queso", 20);
        RawMaterial meat = new RawMaterial("Carne", 10);
        RawMaterial jam = new RawMaterial("Jamón", 20);
        RawMaterial cornSauce = new RawMaterial("Humita", 25);
        RawMaterial vegetables = new RawMaterial("vegetales", 25);

        newList.add(flour);
        if(type == "JyQ"){
            newList.add(jam);
            newList.add(cheese);
        }else if (type == "humita")
            newList.add(cornSauce);
            else if (type == "carne")
                newList.add(meat);
                else {
            newList.add(vegetables);
            newList.add(cheese);
        }
    }

    public static void createListRawMaterialPizza(ArrayList<RawMaterial>newList, String type){
        RawMaterial harina = new RawMaterial("Harina", 50);
        RawMaterial queso = new RawMaterial("Queso", 100);
        RawMaterial pureTomate = new RawMaterial("Pure de Tomate", 60);
        RawMaterial aceitunas = new RawMaterial("Aceitunas verdes", 30);
        RawMaterial aceitunasNegras = new RawMaterial("Aceitunas negras", 30);
        RawMaterial rucula = new RawMaterial("Rúcula", 40);
        RawMaterial jamonCrudo = new RawMaterial("Jamón Crudo", 100);
        RawMaterial calabresa= new RawMaterial("Calabresa", 80);
        RawMaterial cebolla = new RawMaterial("Cebolla", 20);
        RawMaterial tomate = new RawMaterial("Tomate", 25);

            newList.add(harina);
            newList.add(queso);
            newList.add(pureTomate);
            newList.add(aceitunas);
            if (type == "Napolitana" || type == "napolitana")
                newList.add(tomate);
            else if(type == "Fugazzeta" || type == "fugazzeta"){
                newList.add(cebolla);
                newList.remove(aceitunas);
            }
            else if (type == "Rucula" || type == "rucula"){
                newList.add(jamonCrudo);
                newList.add(rucula);
                newList.remove(aceitunas);
                newList.add(aceitunasNegras);
            }
            else if (type == "calabresa" || type == "Calabresa")
                newList.add(calabresa);

    }
    //endregion

    //region SELECTORS

    public static ArrayList<Product> selectProduct () throws IOException {

        ArrayList<Product> newOrder = new ArrayList<>();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while(!out){
            System.out.println("«1. Pizza»");
            System.out.println("«2. Empanada»");
            System.out.println("«3. Bebida»");
            System.out.println("«9. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Menú Pizzas");
                    selectPizza(newOrder);
//                    System.in.read();

                    break;
                case 2:
                    System.out.println("Menu Empanadas");
                    selectEmpanadas(newOrder);
//                    System.in.read();
                    break;
                case 3:
                    System.out.println("Bevidas");
                    selectBeverage(newOrder);
                    break;
                case 9:
                    out=true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
        return newOrder;

    }

    public static void selectBeverage (ArrayList<Product> newOrder){
        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while(!out){
            System.out.println("«1. Coca Cola 1.25lt»");
            System.out.println("«2. Coca Cola 2.5lt»");
            System.out.println("«3. Coca Cola 3lt»");
            System.out.println("«4. Cerveza Quilmes Cristal»");
            System.out.println("«5. Cerveza Quilmes 1890 »");
            System.out.println("«6. Cerveza Quilmes Bock»");
            System.out.println("«7. Sprite 1.25lt»");
            System.out.println("«8. Sprite 2.5lt»");
            System.out.println("«9. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch(option){
                case 1:
                    Beverage beverage = new Beverage("Coca cola",200,200,
                            BeverageBrand.COCACOLA,1.25f, BeverageType.SODA);
                    newOrder.add(beverage);
                    break;
                case 2:
                    Beverage beverage1 = new Beverage("Coca cola",200,200,
                            BeverageBrand.COCACOLA,2.5f, BeverageType.SODA);
                    newOrder.add(beverage1);
                    break;
                case 3:
                    Beverage beverage2 = new Beverage("Coca cola",200,200,
                            BeverageBrand.COCACOLA,3f, BeverageType.SODA);
                    newOrder.add(beverage2);
                    break;
                case 4:
                    Beverage beverage3 = new Beverage("Cristal",200,200,
                            BeverageBrand.QUILMES,1f, BeverageType.ALCOHOLIC);
                    newOrder.add(beverage3);
                    break;

                case 5:
                    Beverage beverage5 = new Beverage("1890",200,200,
                            BeverageBrand.QUILMES,1f, BeverageType.ALCOHOLIC);
                    newOrder.add(beverage5);
                    break;
                case 6:
                    Beverage beverage6 = new Beverage("Bock",200,200,
                            BeverageBrand.QUILMES,1f, BeverageType.ALCOHOLIC);
                    newOrder.add(beverage6);
                    break;
                case 7:
                    Beverage beverage7 = new Beverage("Sprite",200,200,
                            BeverageBrand.COCACOLA,1.25f, BeverageType.SODA);
                    newOrder.add(beverage7);
                    break;
                case 8:
                    Beverage beverage8 = new Beverage("Sprite",200,200,
                            BeverageBrand.COCACOLA,2.5f, BeverageType.SODA);
                    newOrder.add(beverage8);
                    break;

                case 9:
                    out=true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 9»");
            }

        }
    }

    public static void selectEmpanadas(ArrayList<Product> newOrder){

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while(!out){
            System.out.println("«1. Emp. Humita»");
            System.out.println("«2. Emp. JyQ»");
            System.out.println("«3. Emp. Carne»");
            System.out.println("«4. Emp. Verdura»");
            System.out.println("«9. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch(option){
                case 1:
                    ArrayList<RawMaterial>empanadas = new ArrayList<>();

                    createListRawMaterialEmp(empanadas,"humita");
                    Food newFood = createFood(empanadas,"Empanadas","humita",300);
                     newOrder.add(newFood);
//                    System.in.read();

                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");

//                    Food newFood2 = createFood(muzzarella,"Pizza","Calabresa",300);
//                    newOrder.add(newFood2);

//                    System.in.read();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");

//                    Food newFood3 = createFood(muzzarella,"Pizza","Fugazzetta",300);
//                    newOrder.add(newFood3);

//                    System.in.read();
                    break;
                case 4:
                    System.out.println("Has seleccionado la opción 4");
//                    Food newFood4 = createFood(muzzarella,"Pizza","Rúcula y jamón crudo",300);
//                    newOrder.add(newFood4);
                    break;

                case 5:
                    System.out.println("Has seleccionado la opción 5");
//                    Food newFood5 = createFood(muzzarella,"Pizza","Napolitana",300);
//                    newOrder.add(newFood5);
//                    System.in.read();

                    break;
                case 9:
                    out=true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
    }

    public static void selectPizza(ArrayList<Product> newOrder) throws IOException {


        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while(!out){
            System.out.println("«1. Pizza Muzza»");
            System.out.println("«2. Pizza Calabresa»");
            System.out.println("«3. Pizza Fugazzetta»");
            System.out.println("«4. Pizza Rúcula y jamón»");
            System.out.println("«5. Pizza Napolitana»");
            System.out.println("«9. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch(option){
                case 1:
                    System.out.println("Has seleccionado la opcion 1");
                    ArrayList<RawMaterial> rawMaterialsList = new ArrayList<>();
                    createListRawMaterialPizza(rawMaterialsList, "muzzarella");
                    Food newFood = createFood(rawMaterialsList,"Pizza","Muzzarella",300);
                    newOrder.add(newFood);
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    ArrayList<RawMaterial> rawMaterialsList1 = new ArrayList<>();
                    createListRawMaterialPizza(rawMaterialsList1, "calabresa");
                    Food newFood2 = createFood(rawMaterialsList1,"Pizza","Calabresa",300);
                    newOrder.add(newFood2);
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    ArrayList<RawMaterial> rawMaterialsList3 = new ArrayList<>();
                    createListRawMaterialPizza(rawMaterialsList3, "fugazzetta");
                    Food newFood3 = createFood(rawMaterialsList3,"Pizza","Fugazzetta",300);
                    newOrder.add(newFood3);
                    break;
                case 4:
                    System.out.println("Has seleccionado la opción 4");
                    ArrayList<RawMaterial> rawMaterialsList4 = new ArrayList<>();
                    createListRawMaterialPizza(rawMaterialsList4, "rucula");
                    Food newFood4 = createFood(rawMaterialsList4,"Pizza","Rúcula y jamón crudo",300);
                    newOrder.add(newFood4);
                    break;
                case 5:
                    System.out.println("Has seleccionado la opción 5");
                    ArrayList<RawMaterial> rawMaterialsList5 = new ArrayList<>();

                    createListRawMaterialPizza(rawMaterialsList5, "napolitana");
                    Food newFood5 = createFood(rawMaterialsList5,"Pizza","Napolitana",300);
                    newOrder.add(newFood5);
                    break;
                case 9:
                    out=true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }
        }
    }

    //endregion

    //region FILE
    public static void fillFileOptions (String nameFile, ArrayList<Product> food){
            /// el gson ahora tiene formato mas facil de leer
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            /** guardando un archivo con informacion json */

            BufferedWriter fSalida = null;

            try {
                fSalida = new BufferedWriter(new FileWriter(new File(nameFile)));

                gson.toJson(food, food.getClass(), fSalida);

            } catch (IOException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if(fSalida != null) {
                    try {
                        fSalida.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void readFileOptions (String nameFile, List<Food>productList){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(new File(nameFile)));

                productList = gson.fromJson(reader, (new TypeToken<List<Food>>() {}.getType()));

//                System.out.println(productList.getNombre());
//                System.out.println("VIENDO ARCHIVO--------------------------------\n");
//                productList.forEach((v)->System.out.println(v));

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

//endregion



    //tiene que llegar los datos del cliente y la comida a pedir

    //to fill the archive
    public Order createOrder (Client client, ArrayList<Product> newArray,
     float finalPrice, float productPrice,float totalPrice, LocalDateTime dateTime){

        Order newOrder = new Order(client, newArray, finalPrice, productPrice,
        totalPrice, dateTime);

        return newOrder;
    }

    public Delivery createOrderDelivery (Client client, ArrayList<Product> newArray, Employee
            employee, float finalPrice, float productPrice,float totalPrice, LocalDateTime dateTime,float deliveryFloat
    , LocalDateTime out){

        Delivery newDelivery = new Delivery(client, newArray, finalPrice, productPrice,
                totalPrice, dateTime,  deliveryFloat, employee, out);

        return newDelivery;
    }



    //to manage the app
    public void modifyOrder (){

    }
    public void deleteOrder(){

    }

}
