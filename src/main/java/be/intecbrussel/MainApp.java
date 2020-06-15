package be.intecbrussel;

import be.intecbrussel.data.PersonDao;
import be.intecbrussel.data.implementation.PersonDaoImpl;
import be.intecbrussel.model.Person;
import be.intecbrussel.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        PersonDao dao = new PersonDaoImpl();


        try (  ConfigurableApplicationContext context
                       = new AnnotationConfigApplicationContext(PersonSpringConfiguration.class);) {

            PersonService service = context.getBean("mockService",PersonService.class);

            Person guest1 = context.getBean("person",Person.class);
            guest1.setFirstName("Sando");
            guest1.setLastName("Uwi");
            guest1.setDateOfBirth(LocalDate.of(1991,6,15));
            service.addPerson(guest1);
            //other guests
            Person guest2 = context.getBean("person",Person.class);
            guest2.setFirstName("Sandrine");
            guest2.setLastName("Umunyana");
            Person guest3 = context.getBean("person",Person.class);
            guest3.setFirstName("Sandra");
            guest3.setLastName("Ana");

            List<Person> allGuests = new ArrayList<>();
            allGuests.add(guest1);
            allGuests.add(guest2);
            allGuests.add(guest3);
            service.addPersons(allGuests);
            service.getAllPersons().stream().forEach(System.out::println);

            Person guest4 = context.getBean("person",Person.class);
            guest4.setFirstName("Johannah");
            guest4.setLastName("von Hunerbein");
            guest4.setDateOfBirth(LocalDate.of(1991,6,15));
            allGuests.add(guest4);
            service.getAllPersons().stream().forEach(System.out::println);


        } catch (CustomException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}


