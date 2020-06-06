package be.intecbrussel;

import be.intecbrussel.data.PersonDao;
import be.intecbrussel.data.implementation.PersonDaoImpl;
import be.intecbrussel.model.Person;

import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {

        PersonDao dao = new PersonDaoImpl();


        try {
            dao.createPerson(new Person("Umunyana", LocalDate.ofYearDay(1991,15),1,"Sandrine"));

        } catch (CustomException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
