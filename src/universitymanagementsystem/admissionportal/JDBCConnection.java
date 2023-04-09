package universitymanagementsystem.admissionportal;

import java.sql.*;

/**
 *
 * @author Manish Kumar
 */
public class JDBCConnection {
    
    Connection con;
    Statement stmt;
    
    //1.Register the Driver
    //2.Creating Connection String
    //3.Creating Statement
    //4.Executing MySQL Queries
    //5.Closing the Connection
    
    JDBCConnection(){
      try{
          //1.Register the Driver
          Class.forName("com.mysql.cj.jdbc.Driver");
          
          //2.Creating Connection String
          //con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
          con = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","root");
          
          //3.Creating Statement
          stmt = con.createStatement();
          
      }   
      catch(Exception e){
          System.out.println(e);
      }
    }
}
