package be.intecbrussel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private Connection connection;
    //statische methode zodat we het doorheen onze project kunnen gebruiken
    private static ConnectionProvider instance= new ConnectionProvider();

    public Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person_db","root", "root");
        }

        return connection;
    }

    public static ConnectionProvider getInstance() {
        return instance;
    }
}
