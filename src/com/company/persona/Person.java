package com.company.persona;

public abstract class Person {

    private String name;
    private String lastname;

    //region CONSTRUCTORS
    public Person(){}

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    //endregion

    //region GETTER & SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    //endregion


    //region HELPERS
    @Override
    public String toString (){
        return  "Name: " + getName() +
                "\nLastName: " + getLastname();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Person))
            return false;

        Person person = (Person) o;
        boolean answer = this.lastname == person.lastname
                && this.name == person.name;

        return answer;
    }

    @Override
    public int hashCode() {
        int answer = this.name.hashCode();
        answer += 31 * this.lastname.hashCode();
        return answer;
    }
    //endregion
}
