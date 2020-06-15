package be.intecbrussel.data.implementation;

import be.intecbrussel.ConnectionProvider;
import be.intecbrussel.CustomException;
import be.intecbrussel.data.PersonDao;
import be.intecbrussel.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDaoImpl implements PersonDao {

    private List<Person> personDB = new ArrayList<>();

    public List<Person> getPersonDB() throws CustomException, SQLException {

        return new ArrayList<>(personDB);
    }

    //crud-methode geen duplicaten
    @Bean
    @Override
    public boolean createPerson(Person createPerson) throws CustomException {

        if(!personDB.contains(createPerson)) {
            personDB.add(createPerson);
            System.out.printf("A new person was created: ", createPerson.getId());
        }else {
            return false;
        }
        return false;
    }

    @Override
    public Person readPerson(int numberOfReadPeople) throws CustomException {
        Optional<Person> person = personDB.stream().filter(p -> p.getId() == numberOfReadPeople).findFirst();
        if (person.isPresent()) {
            return personDB.get(numberOfReadPeople);
        } else {
            return null;
        }

    }

    @Bean
    @Override
    public boolean updatePerson(Person numberOfUpdatedPerson) throws CustomException {
       if(personDB.contains(numberOfUpdatedPerson)){
            int index = personDB.indexOf(numberOfUpdatedPerson);
            personDB.get(index).equals(numberOfUpdatedPerson);
            System.out.printf("Person id-number " + numberOfUpdatedPerson.getId(),index);
            return true;

       /* Here is another way to solve it. Jut don't forget to create the personExists method
        if (personExists(person)) {
            personDB.removeIf(person1 -> person1.getId() == person.getId());
            personDB.add(person);
            return true;*/
        } else{
            System.out.println("Not available on the list.");
            return false;
        }

    }

    @Override
    public boolean deletePerson(Person numberOfDeletedPerson) throws CustomException {
        if(personDB.contains(numberOfDeletedPerson)) {
            personDB.remove(numberOfDeletedPerson);
            return true;
        } else {
            return false;
        }

    }

}
