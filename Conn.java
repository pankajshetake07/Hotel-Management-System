package Hotel_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn
{
    Connection c;
    static Statement s;
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  //register driver
            c = DriverManager.getConnection("jdbc:mysql:///Hotel_Management_System","root","pankajshetake"); //connection creation
            s = c.createStatement();  //Query Execution using statement class
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
