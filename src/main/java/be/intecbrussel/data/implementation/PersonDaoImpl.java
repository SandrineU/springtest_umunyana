package be.intecbrussel.data.implementation;

import be.intecbrussel.data.PersonDao;
import be.intecbrussel.model.Person;
import org.springframework.stereotype.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(value = "mockDao")
public class PersonDaoImpl implements PersonDao {

    private List<Person> personDB = new ArrayList<>();

    //crud-methode geen duplicaten
    @Override
    public boolean createPerson(Person createPerson) {

        if(!personDB.contains(createPerson)) {
            personDB.add(createPerson);
            System.out.printf("A new person was created: ", createPerson.getId());
            return true;
        }else {
            personDB.add(createPerson);
        }
        return false;
    }

    @Override
    public Person readPerson(int numberOfReadPeople) {
        Optional<Person> person = personDB.stream().filter(p -> p.getId() == numberOfReadPeople).findFirst();
        if (person.isPresent()) {
            return personDB.get(numberOfReadPeople);
        } else {
            return null;
        }

    }

    @Override
    public boolean updatePerson(Person numberOfUpdatedPerson){
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
    public boolean deletePerson(Person numberOfDeletedPerson)  {
        if(personDB.contains(numberOfDeletedPerson)) {
            personDB.remove(numberOfDeletedPerson);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Person> getAllPersons(){
        return personDB;

    }

}
