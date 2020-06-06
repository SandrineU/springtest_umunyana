package be.intecbrussel.data.implementation;

import be.intecbrussel.ConnectionProvider;
import be.intecbrussel.CustomException;
import be.intecbrussel.data.PersonDao;
import be.intecbrussel.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    public static final List<Person> personDB = new ArrayList<>();


    public Connection createConnection() throws SQLException {
        return ConnectionProvider.getInstance().getConnection();
    }

    public List<Person> getPersonDB() throws CustomException, SQLException {

        List<Person> personDB = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     createConnection().prepareStatement("SELECT * FROM person")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("person_id"));
                    person.setLastName((resultSet.getString("person_LastName")));
                    personDB.add(person);
                }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new CustomException();
        }

    }
        return personDB;
    }

    //crud-methode geen duplicaten
    @Override
    public boolean createPerson(Person createPerson) throws CustomException {

        if(!personDB.contains(createPerson)) {
            personDB.add(createPerson);
            System.out.printf("A new person was created: ", createPerson.getId());
        }else{
            System.out.printf("No new person was created: ", createPerson.getId());
        }
        return personDB.contains(createPerson);

    }

    @Override
    public Person readPerson(int numberOfReadPeople) throws CustomException {
        return personDB.get(numberOfReadPeople);
    }

    @Override
    public boolean updatePerson(Person numberOfUpdatedPerson) throws CustomException {
        if(personDB.contains(numberOfUpdatedPerson)){
            int index = personDB.indexOf(numberOfUpdatedPerson);
            System.out.printf("Person id-number " + numberOfUpdatedPerson.getId(),index);
            return personDB.get(index).equals(numberOfUpdatedPerson);
        } else{
            System.out.println("Not available on the list.");
            return false;
        }

    }

    @Override
    public boolean deletePerson(Person numberOfDeletedPerson) throws CustomException {
        return personDB.remove(numberOfDeletedPerson);
    }

}
