package restaurant;

import java.sql.*;
import java.util.EmptyStackException;

public class BDD {

    public BDD() {
    }
    
    public static Connection getConnection() {
    	
        try {
            String protocole = "jdbc:mysql:";
            String ip = "localhost";
            String port = "3306";
            String bddName = "Restaurant";
            String connection = protocole + "//" + ip + ":" + port + "/" + bddName;
            String userName = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(connection, userName, password);

            return con;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        throw new EmptyStackException();
    }    
}
// java -cp mysql-connector-java-8.0.23.jar:.: BDD.java 