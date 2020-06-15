package be.intecbrussel.data;

import be.intecbrussel.model.Person;

import java.sql.SQLException;
import java.util.List;


public interface PersonDao {

    boolean createPerson (Person person);
    Person readPerson(int id);
    boolean updatePerson(Person person);
    boolean deletePerson(Person person);
    List<Person> getAllPersons();

}
