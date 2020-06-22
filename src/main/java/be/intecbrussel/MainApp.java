package be.intecbrussel;

import be.intecbrussel.model.Person;
import be.intecbrussel.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

          try(ConfigurableApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(PersonSpringConfiguration.class)) {

              PersonService personService = (PersonService) applicationContext.getBean("mockService");

              System.out.println("Hieronder zit de guest list: ");
              Person guest1 = new Person(1);
              guest1.setFirstName("Sandrine");
              guest1.setLastName("Umunyana");
              guest1.setDateOfBirth(LocalDate.of(1999, 02, 07));
              System.out.println(guest1);

              List<Person> guestList = new ArrayList<>();
              Person guest2 = new Person("Umu", LocalDate.of(1991, 6, 15), 2, "Sandrine");
              Person guest3 = new Person("Ana", LocalDate.of(1991, 5, 15), 3, "Sand");
              Person guest4 = new Person("Yana", LocalDate.of(1991, 4, 15), 4, "Rine");
              guestList.add(guest2);
              guestList.add(guest3);
              guestList.add(guest4);
              personService.addPersons(guestList);
              System.out.println(guestList);
              personService.getAllPersons().stream().forEach(System.out::println);

              System.out.println("Person with id 2: " + guestList.get(2));


          }
    }
}


