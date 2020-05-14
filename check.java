/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author shivam
 */
public class check {
    check() throws SQLException
           
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("loaded");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Shivam@12");
            System.out.println("connection establish");
            DatabaseMetaData dbmd=con.getMetaData();  
            String table[]={"VIEW"};  
           ResultSet rs=dbmd.getTables(null,null,null,table);  
           while(rs.next()){  
          System.out.println(rs.getString(3));  
               }  
  
con.close();  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws SQLException
    {
        new check();
    }
}
