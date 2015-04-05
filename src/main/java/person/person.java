/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import Connect.Connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;


/**
 *
 * @author c0645743
 */

public class person extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            /* TODO output your page here. You may use following sample code. */
            
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
        Connection con=null;
        String msg=null;
        String category_name=request.getParameter("name");
           
            
        con=Connect.getConnection();
            
        PreparedStatement st=con.prepareStatement("insert into student(s_fname) values (?)");
        st.setString(1, category_name);
        int code= st.executeUpdate();
            
            if(code>0)
            {
                msg="Successfully Inserted!";
            }
            else
            {
                msg="Not Inserted!";
            }
            
            request.setAttribute("msg",msg );
            
            RequestDispatcher rd=request.getRequestDispatcher("category.jsp");
            rd.forward(request, response);
           
        }
        catch (Exception ex) {
                System.out.println(ex.toString());
            }
        finally {
            out.close();
        }
    }
}
