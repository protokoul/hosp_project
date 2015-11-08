/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hosp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author abhishekraina
 */
public class DatabaseHelper {
    private static DatabaseHelper instance = new DatabaseHelper();
    public static final String URL = "jdbc:mysql://localhost/tester";
    public static final String USER = "root";
    public static final String PASSWORD = "hospital";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    
    private DatabaseHelper() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private Connection createConnection() {
 
        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
    
    public static Connection getConnection() {
        return instance.createConnection();
    }
    
    
     
}
