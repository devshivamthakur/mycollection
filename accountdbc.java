
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
public class accountdbc {
    public static Connection getcon() throws ClassNotFoundException
    {    
        Connection con=null;
        try
        {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                   System.out.println("loaded");
                   con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Shivam@12");
                        System.out.println("connection establish");
        }
        catch(Exception e1)
        {
           System.out.println("ex:"+e1.getMessage());
        }
 
        return con;
    }
    public static boolean valid(String username,String password)
    {
        boolean status=false;
        try
        {
            Connection con=getcon();
            
            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from account where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }catch(Exception e)
        {
         System.out.print(e);
        }
        return status;
        
    }
    public static int save(account a1)
    { 
        int status=0;
       // account a1=new account();
        String name = null,phoneno="",username="",password="";
        name=a1.getname();
          phoneno= a1.getphoneno();
           username=a1.getusername();
            password= a1.getpassword();
        
           System.out.println(name+" "+phoneno+""+username+" "+password);
        try
        {
            Connection con=accountdbc.getcon();
            PreparedStatement ps=con.prepareStatement("insert into account (name,phoneno,username,password)values(?,?,?,?)");
            
            ps.setString(1,a1.getname() );
            ps.setString(2, a1.getphoneno());
            ps.setString(3,a1.getusername());
            ps.setString(4, a1.getpassword());
            //ResultSet set=ps.executeQuery();
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
     public static int update(account s,String name)
   {
       Connection con=null;
       int status=0;
       try
       {
           con=accountdbc.getcon();
           PreparedStatement ps=con.prepareStatement("update account set name=?,phoneno=?,username=?,password=? where name=?");
          ps.setString(1, s.getname());
            ps.setString(2, s.getphoneno());
            ps.setString(3, s.getusername());
            ps.setString(4,s.getpassword());
            ps.setString(5, name);
                        status=ps.executeUpdate();
            con.close();
            
       }catch(Exception e)
       {
           System.out.print(e.getMessage());
       }
       return status;
   }

    public static ArrayList <account> view()
    {
                ArrayList<account> list=new ArrayList<account>();
     try
      {
              Connection con=accountdbc.getcon();
              PreparedStatement ps=con.prepareStatement("select * from account");
              System.out.println("connection estabilish on account jdbc");
              ResultSet rs=ps.executeQuery();
              while(rs.next())
              {
                account a1=new account();
                a1.setname(rs.getString("name"));
                a1.setphoneno(rs.getString("phoneno"));
                a1.setusername(rs.getString("username"));
                a1.setpassword(rs.getString("password"));
                list.add(a1);
                  
              }
              con.close();
      }catch(Exception e)
      { 
                  
         System.out.println(e);

       }
      return list;   
    }
  
  public static void main(String [] args)
          
  {
    
   
      
  }
  public static int delete(String s)
    {
        int status=0;
        try
        {
            Connection con=accountdbc.getcon();
            PreparedStatement ps=con.prepareStatement("DELETE FROM account WHERE name=?");
            ps.setString(1,s);
            
            status=ps.executeUpdate();
            System.out.println("status ="+status);
            con.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
   
    
}
