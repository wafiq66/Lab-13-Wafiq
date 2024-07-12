/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DBConnection {
    
    private static Connection conn;
    private DBConnection() {}
    
     public static Connection createConnection(){
         if (conn == null) {
            try {
                String driver = "org.apache.derby.jdbc.ClientDriver";
                String connectionString = "jdbc:derby://localhost:1527/customers";
                String username = "app";
                String password = "app";
                
                Class.forName(driver);
                conn = DriverManager.getConnection(connectionString, username, password);
                
                System.out.println("Connection Successful");
            } catch (ClassNotFoundException e) {
                System.out.println("Oracle JDBC driver not found");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Connection Failed");
                e.printStackTrace();
            }
        }
        return conn;
     }
    
}
