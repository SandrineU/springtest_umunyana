package be.intecbrussel;

import be.intecbrussel.data.PersonDao;
import be.intecbrussel.data.implementation.PersonDaoImpl;
import be.intecbrussel.model.Person;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        PersonDao dao = new PersonDaoImpl();


        try {
            List<Person> otherGuests = new ArrayList<>();
            dao.createPerson(new Person("Umunyana", LocalDate.of(1991,15,06),1,"Sandrine"));
            otherGuests.add(new Person("Black", LocalDate.of(2000,15,06),1,"DBanj"));

        } catch (CustomException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

   }
}
