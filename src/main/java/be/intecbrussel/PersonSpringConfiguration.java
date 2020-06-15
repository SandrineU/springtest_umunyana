package be.intecbrussel;

import be.intecbrussel.data.implementation.PersonDaoImpl;
import be.intecbrussel.service.implementation.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = {"be.intecbrussel"})
public class PersonSpringConfiguration {

    @Bean
    public PersonDaoImpl mockDao(){
        return new PersonDaoImpl();
    }

    @Bean
    public PersonServiceImpl mockService(PersonDaoImpl mockDao){
        return new PersonServiceImpl();
    }
}
