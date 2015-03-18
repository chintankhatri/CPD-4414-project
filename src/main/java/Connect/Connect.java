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
        String hostname = System.getenv("127.13.153.130");
        String portnum = System.getenv("3306");
        String user = System.getenv("adminT5yrrEn");
        String pass = System.getenv("zTJQJ2DKxR_G");
        String jdbc = "jdbc:mysql://" + hostname + ":" + portnum + "/jbosswildfly";
        return DriverManager.getConnection(jdbc, user, pass);
    }

    public static JsonArray getResults(String sql, String... params) {
        JsonArray json = null;
        try {
            JsonArrayBuilder array = Json.createArrayBuilder();
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setString(i + 1, params[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                array.add(Json.createObjectBuilder()
                        .add("p_id", rs.getInt("p_id"))
                        .add("p_name", rs.getString("p_name"))
                );
            }
            conn.close();
            json = array.build();
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

}
