/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RegisterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;
/**
 *
 * @author user
 */
public class RegisterDao {
    
    public String registerUser(RegisterBean registerBean){
    
        Connection con = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int nextId = 0;
        
        try{
            con = DBConnection.createConnection();
            
            // Get the maximum ID from the table
            statement = con.createStatement();
            resultSet = statement.executeQuery("select max(id) as max_id from usertable");
            if(resultSet.next()){
                nextId = resultSet.getInt("max_id") + 1;
            } else {
                nextId = 1; // If the table is empty, start with ID 1
            }
            
            // Insert the new user with the next ID
            String query = "insert into usertable (id, username, password, fullname, email) values (?, ?, ?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, nextId);
            preparedStatement.setString(2, registerBean.getUsername());
            preparedStatement.setString(3, registerBean.getPassword());
            preparedStatement.setString(4, registerBean.getName());
            preparedStatement.setString(5, registerBean.getEmail());
            preparedStatement.executeUpdate();
            return "SUCCESS";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Failed to register user";
        
    }
    
}
