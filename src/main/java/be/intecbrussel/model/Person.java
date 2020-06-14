package be.intecbrussel.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;

public class Person {

    private String lastName;
    private LocalDate dateOfBirth;
    private int id;
    private String firstName;
    // what does the logger do?
    private Logger logger;

    public Person(Logger logger) {
        this.logger=logger;
        logger.info("create Person object with this id: "+ id);
    }

    public Person(String lastName, LocalDate dateOfBirth, int id, String firstName) {
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = ++id;
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


    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfBirth);
    }

    public boolean equals (Object object){
        if (this == object) return true;
        if (!(object instanceof Person)) return false;
        //check values in property field
        Person person = (Person) object;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(dateOfBirth, person.dateOfBirth);
         }

    public int hashCode (int hashNumber){
        return Objects.hash(id, firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Person{" + "lastName='" + lastName + '\'' + ", dateOfBirth=" + dateOfBirth + ", id=" + id + ", firstName='" + firstName + '\'' + '}';
    }
}
