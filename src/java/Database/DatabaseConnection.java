/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ankit
 */
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;

// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    public static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.cj.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL "; 
        // Database name to access 
        String dbName = "hospital"; 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL); 
        Statement stmt = con.createStatement();
        stmt.execute("use " + dbName + ";");
//         stmt.execute("insert into login values('chirag','1234')");
//      
        return con; 
    }
    
//    public static void main(String[] args) {
//        try {
//            // Initialize database connection
//            Connection connection = initializeDatabase();
//            
//            // Check if connection is successful
//            if (connection != null) {
//                System.out.println("Database connection established successfully.");
//                
//                // Close connection
//                connection.close();
//            } else {
//                System.out.println("Failed to establish database connection.");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
}

    
    
