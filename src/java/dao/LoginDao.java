/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.LoginBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;
/**
 *
 * @author user
 */
public class LoginDao {
    
    public String authenticateUser(LoginBean loginBean){
    
        String userName = loginBean.getUsername();
        String password = loginBean.getPassword();
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        
        try{
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password from usertable");
            while(resultSet.next()){
            
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                
                if(userName.equals(userNameDB) && password.equals(passwordDB)){
                    return "SUCCESS";
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
        
    }
    
}
