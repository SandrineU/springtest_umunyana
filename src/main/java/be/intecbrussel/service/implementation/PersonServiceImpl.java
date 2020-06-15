package be.intecbrussel.service.implementation;

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

    @Override
    public List<Person> getAllPersons(){
        return new ArrayList<Person>();
    }

    @Override
    public Person getPerson(int numberOfPerson) {
        return personDao.readPerson(numberOfPerson);
    }

    @Override
    public void addPerson(Person newPerson) {
        personDao.createPerson(newPerson);
    }

    @Override
    public void addPersons(List<Person> personList){
        for (Person people : personList) {
            personDao.createPerson(people);
        }
    }


}
