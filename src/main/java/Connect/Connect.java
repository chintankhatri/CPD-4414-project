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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //  Connection.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        String hostname = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String portnum = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        String jdbc = "jdbc:mysql://" + hostname + ":" + portnum + "/jbosswildfly";
        return DriverManager.getConnection(jdbc, user, pass);
    }

   

}
