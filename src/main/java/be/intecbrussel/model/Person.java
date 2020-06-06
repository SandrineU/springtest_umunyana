package be.intecbrussel.model;

import java.time.LocalDate;

public class Person {

    private String lastName;
    private LocalDate dateOfBirth;
    private int id;
    private String firstName;

    public Person() {
    }

    public Person(String lastName, LocalDate dateOfBirth, int id, String firstName) {
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean equals (Object object){
        return true;
    }

    public int hashCode (int hashNumber){
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" + "lastName='" + lastName + '\'' + ", dateOfBirth=" + dateOfBirth + ", id=" + id + ", firstName='" + firstName + '\'' + '}';
    }
}
