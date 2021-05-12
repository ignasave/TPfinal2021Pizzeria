package Ignacio.guia2.ejercicio3;

import java.util.LinkedList;
import java.util.UUID;

public class Cuenta {
    private UUID id;
    private float balance;
    private Cliente client;
    private LinkedList operations = new LinkedList();

    public Cuenta() {
    }

    public Cuenta(float balance, Cliente client) {
        this.id = UUID.randomUUID();
        this.balance = balance;
        this.client = client;
    }


    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public UUID getId() {
        return id;
    }

    private void setOperation(String operation, float amount) {
        operations.addFirst(this.client.getName() + ", " + operation + " " + String.valueOf(amount));
        if(operations.size() > 10) {
            operations.removeLast();
        }
    }

    public void showOperations(){
        for (Object curr: operations) {
            System.out.println(curr.toString());
        }
    }

    public void deposit(float deposit){
        if(deposit > 0 ){
            this.balance += deposit;
            setOperation("deposito", deposit);
        }
        else {
            System.out.println("Debe depositar valores mayores a cero");
        }
    }

    public void extract(float extraction){
        if(extraction <= this.balance){
            this.balance -= extraction;
            setOperation("retiro", extraction);
        }
        else {
            System.out.println("La cuenta no posee saldo suficiente");
        }
    }

    public void extractWithDebt(float extraction){
        if((this.balance - extraction) >= -2000){
            this.balance -= extraction;
            setOperation("retiro", extraction);
        }
        else {
            System.out.println("La cuenta no posee saldo suficiente");
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", balance=" + balance +
                ", client=" + client +
                '}';
    }
}
