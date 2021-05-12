package Ignacio.guia1.Enunciado4;
    //MAINCODE
/*        Enunciado4 cuenta = new Enunciado4(1, "Ignacio", 15000);
        cuenta.credit(2500);
        System.out.println(cuenta.toString());
        cuenta.debit(1500);
        System.out.println(cuenta.toString());
        cuenta.debit(30000);
        System.out.println(cuenta.toString());*/

public class Enunciado4 {
    private int id;
    private String name;
    private float balance;

    public Enunciado4() {
    }

    public Enunciado4(int id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public float credit (float money) {
        this.balance += money;
        return this.balance;
    }

    public float debit (float money) {
        if(money > this.balance) {
            System.out.println("No hay suficiente dinero en la cuenta");
        } else {
            this.balance -= money;
        }
        return this.balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", NOMBRE: " + name + ", BALANCE: " + balance;
    }
}
