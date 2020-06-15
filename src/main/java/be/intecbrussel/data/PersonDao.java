package be.intecbrussel.data;

import be.intecbrussel.CustomException;
import be.intecbrussel.model.Person;


public interface PersonDao {

    boolean createPerson (Person person) throws CustomException;
    Person readPerson(int id)throws CustomException;
    boolean updatePerson(Person person)throws CustomException;
    boolean deletePerson(Person person)throws CustomException;


}
