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

    private List<Person> personDB;

    public PersonDaoImpl() {

    }

    public Connection createConnection() throws SQLException {
        return ConnectionProvider.getInstance().getConnection();
    }

    public PersonDaoImpl(List<Person> personDB) {
        this.personDB = personDB;
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

        try (PreparedStatement preparedStatement = createConnection().prepareStatement("INSERT INTO person_db(first_name, last_name) " +
                "VALUES (?,?)")) {

            preparedStatement.setString(1, createPerson.getFirstName());
            preparedStatement.setString(2, createPerson.getLastName());
            preparedStatement.execute();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
            throw new CustomException("Something went wrong while creating a new Person");
        }
        return false;
    }

    @Override
    public Person readPerson(int numberOfReadPeople) throws CustomException {
        try (PreparedStatement preparedStatement =
                     createConnection().prepareStatement("SELECT * FROM person where person_id=?")) {
            preparedStatement.setInt(1, numberOfReadPeople);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Person person = new Person();

                if (resultSet.next()) {
                    person.setId(resultSet.getInt("person_id"));
                    person.setFirstName(resultSet.getString("first_name"));
                    person.setLastName(resultSet.getString("last_name"));
                    return person;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new CustomException();
        }
    }

    @Override
    public boolean updatePerson(Person numberOfUpdatedPerson) throws CustomException {
        try (PreparedStatement preparedStatement =
                     createConnection().prepareStatement("UPDATE person SET person_lastName= ? where person_id=?")) {

            preparedStatement.setString(1, numberOfUpdatedPerson.getLastName());
            preparedStatement.setInt(2, numberOfUpdatedPerson.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            throw new CustomException();
        }
        return false;
    }

    @Override
    public boolean deletePerson(Person numberOfDeletedPerson) throws CustomException {
        try (PreparedStatement preparedStatement =
                     createConnection().prepareStatement("DELETE FROM person where person_id=?")) {

            preparedStatement.setInt(1, numberOfDeletedPerson.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            throw new CustomException();
        }
        return false;
    }

}
