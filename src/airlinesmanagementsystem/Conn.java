
package airlinesmanagementsystem;
import java.sql.*;

public class Conn 
{
    Connection c;
    Statement s;
    public Conn()
            {
                try
                {
                    //Class.forName("com.mysql.cj.jdbc.driver");//register the driver
                    c= DriverManager.getConnection("jdbc:mysql:///airlinesmanagementsystem" , "root" , "SATYAMKUMAR6324");
                    s=c.createStatement();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
}
