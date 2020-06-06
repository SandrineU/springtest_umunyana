package be.intecbrussel.service.implementation;

import be.intecbrussel.CustomException;
import be.intecbrussel.data.PersonDao;
import be.intecbrussel.data.implementation.PersonDaoImpl;
import be.intecbrussel.model.Person;
import be.intecbrussel.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService<Person> {

    protected PersonDao personDao = new PersonDaoImpl();


    @Override
    public List<Person> allPersons() throws CustomException {
        return allPersons();

        //not sure
    }

    @Override
    public Person getPerson(int numberOfPerson) throws CustomException {
        return personDao.readPerson(numberOfPerson);
    }

    @Override
    public void addPerson(Person newPerson) throws CustomException {
        personDao.createPerson(newPerson);
    }

    @Override
    public void addPersons(List<Person> personList) throws CustomException { ;
    //how to write the correct method?
    }


}
