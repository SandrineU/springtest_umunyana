package be.intecbrussel.service.implementation;

import be.intecbrussel.CustomException;
import be.intecbrussel.data.PersonDao;
import be.intecbrussel.data.implementation.PersonDaoImpl;
import be.intecbrussel.model.Person;
import be.intecbrussel.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    protected PersonDao personDao = new PersonDaoImpl();

    @Override
    public List<Person> getAllPersons() throws CustomException {
        return PersonDaoImpl.personDB;
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
        for (Person people : personList) {
            personDao.createPerson(people);
        }
    }


}
