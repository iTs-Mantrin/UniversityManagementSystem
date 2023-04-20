package universitymanagementsystem.home;

import java.sql.*;

/**
 *
 * @author Manish Kumar
 */
public class JDBCConnection {
    
    Connection con;
    public Statement stmt;
    
    //1.Register the Driver
    //2.Creating Connection String
    //3.Creating Statement
    //4.Executing MySQL Queries
    //5.Closing the Connection
    
    public JDBCConnection(){
      try{
          //1.Register the Driver
          Class.forName("com.mysql.cj.jdbc.Driver");
          
          //2.Creating Connection String
//          con = DriverManager.getConnection("jdbc:mysql://34.72.250.161:3306/universitymanagementsystem","root","root");
          //con = DriverManager.getConnection("jdbc:mysql://uqschvatciafcmv4:t1b0OEYGsWiZEUo0u6oe@brwrdlse0qvxs5ycrxbo-mysql.services.clever-cloud.com:3306/brwrdlse0qvxs5ycrxbo","uqschvatciafcmv4","t1b0OEYGsWiZEUo0u6oe");
          con = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","root");
          
          //3.Creating Statement
          stmt = con.createStatement();
          
      }   
      catch(Exception e){
          System.out.println(e);
      }
    }
}
