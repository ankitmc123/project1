/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.UUID;

/**
 *
 * @author Admin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

    private String user;
    private String pass;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        HttpSession session = request.getSession( );
        
        
        
        
        
        PrintWriter pw = response.getWriter();
        try {
            String userp = request.getParameter("username");
            String passp = request.getParameter("password");
            Connection con = DatabaseConnection.initializeDatabase();
           
            String s = "select *from login where user='"+userp+"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                user = rs.getString(1);
                pass = rs.getString(2);
            }

//  
// if (rs.next())

         if (userp.equals(user) && passp.equals(pass)) {
             
             
             
             
             session.setAttribute("user",userp); 
             
             
             
             
               String g=UUID.randomUUID().toString().toUpperCase();
                 Cookie c = new Cookie("t",g ); 
            response.addCookie(c); 
            st.execute("UPDATE login SET t = '"+g+"' WHERE user = '"+userp+"';");
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Login Successfully..!');");
                pw.println("window.location.href = \"UserHome.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
                //rd.forward(request, response);
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Username or Password is Incorrect..!');");
                pw.println("window.location.href = \"index.jsp\";");
                pw.println("</script>");
                // RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                // rd.include(request, response);
            }
        } catch (Exception e) {

        }

    }

}