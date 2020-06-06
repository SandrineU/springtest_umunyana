package be.intecbrussel.service;

import be.intecbrussel.CustomException;
import be.intecbrussel.model.Person;

import java.util.List;

public interface PersonService {

     List<Person> getAllPersons() throws CustomException;
     Person getPerson(int numberOfPerson) throws  CustomException;
     void addPerson(Person newPerson) throws  CustomException;
     void addPersons(List<Person> personList) throws  CustomException;
}
