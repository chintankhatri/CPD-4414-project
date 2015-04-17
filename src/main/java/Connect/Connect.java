package Connect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author c0645743
 */
public class Connect {

    public static Connection getConnection() throws SQLException {
             Connection conn = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://localhost/db";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(jdbc, user, pass);
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
        
    }

   

}
