package be.intecbrussel.service;

import be.intecbrussel.model.Person;

import java.util.List;

public interface PersonService {

     List<Person> getAllPersons() ;
     Person getPerson(int numberOfPerson) ;
     void addPerson(Person newPerson);
     void addPersons(List<Person> personList);
}
