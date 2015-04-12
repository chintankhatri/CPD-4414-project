/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import static Connect.Connect.getConnection;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author c0637609
 */
@Path("/form")
public class Register {

    @POST
    public String post(String str) {
        try {
            JsonObject json = Json.createReader(new StringReader(str)).readObject();
            String title = json.getString("cname");

            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student (s_fname) VALUES (?)");
            pstmt.setString(1, title);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

//    @GET
//    @Path("{id}")
//    public String get(@PathParam("id") int id) {
//        String result = "";
//        try {
//            Connection conn = Connect.Connect.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM register WHERE username = ?, password =  ? ");
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
//            rs.next();
//            JsonObject json = Json.createObjectBuilder()
//                    .add("title", rs.getString("title"))
//                    .add("text", rs.getString("text"))
//                    .add("time", rs.getString("time"))
//                    .add("id", rs.getInt("id"))
//                    .build();
//            result = json.toString();
//        } catch (SQLException ex) {
//            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
}
