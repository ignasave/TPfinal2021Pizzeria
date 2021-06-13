package com.company.Person;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private String address;
    private String telNumber;

    //region CONSTRUCTOR

    public Client() {
    }

    public Client(String firstName, String lastName, String address, String telNumber) {
        super(firstName, lastName);
        this.address = address;
        this.telNumber = telNumber;
    }

    //endregion

    //region GETTER & SETTER

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    //endregion

    //region HELPER

    @Override
    public String toString() {
        return "Client{" + super.toString() +
                "address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Client))
            return false;

        Client client = (Client) o;
        boolean answer = super.equals(o) && this.telNumber == client.getTelNumber();

        return answer;
    }

    @Override
    public int hashCode() {
        int answer = super.hashCode();
        answer += 31 * this.telNumber.hashCode();
        return answer;
    }

    //endregion







    /*

    public class Client extends Person  {


    private String address;
    private String telNumber;
    private static List<Client> clientArray = new ArrayList<>();


    //region Construct

    public Client(){}

    public Client(String firstName, String lastName, String address, String telNumber) {
        super(firstName, lastName);
        this.address = address;
        this.telNumber = telNumber;


        clientToFileArray(this);

    }


    //endregion


    //region getter y setter

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public static List<Client> getClientArray() {
        return clientArray;
    }

    public static void setClientArray(List<Client> clientArray) {
        Client.clientArray = clientArray;
    }

    //endregion


    //region Helper

    @Override
    public String toString() {
        return "Client{" + super.toString() +
                "address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +

                '}';
    }


    //endregion



    public  static void fileToArrayOfClients(){         //lee el archivo  client.json y pasa su contenido a clientArray para no perder
                                                         // los datos ya que  despues el arreglo siempre sobreescribe el archivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("client.json")));
            clientArray = gson.fromJson(reader,new TypeToken<List<Client>>(){}.getType());

        }catch(IOException e){
            System.out.println("Creando Archivo: ");
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


    public  void  clientToFileArray(Client cliente){   //sobreescribe archivo con el clientArray (donde estan todos los clientes)

        fileToArrayOfClients();
        clientArray.add(cliente);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida  = null;
        try{

            fSalida = new BufferedWriter(new FileWriter(new File( "client.json")));
            String json = gson.toJson(clientArray,clientArray.getClass());
            System.out.println( "soy el string jason \n " + json);
            fSalida.write(json);

        }catch(IOException e){
            System.out.println("creando archivo client.json");
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

    public static void readFileArrayClient(){  ///abre archivo clientArray , lee su contenido y printea
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;

        try{

            reader = new BufferedReader(new FileReader(new File("client.json")));
            clientArray = gson.fromJson(reader,new TypeToken<List<Client>>(){}.getType());

            System.out.println("Soy archivo cliente\n--------------------------------------------");
            for(Client cliente: clientArray){
                if(cliente != null){
                    System.out.println("Nombre: " + cliente.firstName);
                    System.out.println("Apellido: " + cliente.lastName);
                    System.out.println("Direccion: " + cliente.address);
                    System.out.println("Telefono: " + cliente.telNumber);
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

}


     */
}