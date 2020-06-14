package be.intecbrussel;

import be.intecbrussel.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.logging.Logger;

@Configuration
@ComponentScan
public class PersonSpringConfiguration {
    private int id = 0;

    //c,d
    @Bean
    @Scope("prototype")
    public Person person() {
        Person p = new Person(Logger.getLogger(Person.class.getName()));
        p.setId(id++);
        return p;
    }
}
