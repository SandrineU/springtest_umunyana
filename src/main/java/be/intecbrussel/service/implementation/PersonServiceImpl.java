package be.intecbrussel.service.implementation;

import be.intecbrussel.CustomException;
import be.intecbrussel.data.PersonDao;
import be.intecbrussel.model.Person;
import be.intecbrussel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "mockService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getAllPersons() throws CustomException {
        return new ArrayList<Person>();
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
