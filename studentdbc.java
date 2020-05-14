
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
public class studentdbc {
    public static int save(student s)
    {
        Connection con=null;
    int status=0;
        try
        {
            con=accountdbc.getcon();
            System.out.println("connection taken");
            PreparedStatement ps=con.prepareStatement("insert into student(name,email,course,phoneno,totalfee,fee,due,address) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, s.getname());
            ps.setString(2, s.getemail());
            ps.setString(3, s.getcourse());
            ps.setString(4,s.getphoneno() );
            ps.setInt(5, s.gettotalfee());
            ps.setInt(6, s.getfee());
            ps.setInt(7,s.getdue());
            ps.setString(8, s.getaddress());
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
   public static int update(student s,String name)
   {
       Connection con=null;
       int status=0;
       try
       {
           con=accountdbc.getcon();
           PreparedStatement ps=con.prepareStatement("update  student set name=?,email=?,course=?,phoneno=?,totalfee=?,fee=?,due=?,address=? where name=? ");
          ps.setString(1, s.getname());
            ps.setString(2, s.getemail());
            ps.setString(3, s.getcourse());
            ps.setString(4,s.getphoneno() );
            ps.setInt(5, s.gettotalfee());
            ps.setInt(6, s.getfee());
            ps.setInt(7,s.getdue());
            ps.setString(8, s.getaddress());
            ps.setString(9, name);
            status=ps.executeUpdate();
            con.close();
            
       }catch(Exception e)
       {
           System.out.print(e.getMessage());
       }
       return status;
   }

    /**
     *
     * @return
     */
    public static ArrayList <student> view()
  {
      ArrayList<student> list=new ArrayList<student>();
               
      try
      {
              Connection con=accountdbc.getcon();
              PreparedStatement ps=con.prepareStatement("select * from student");
              ResultSet rs=ps.executeQuery();
              while(rs.next())
              {
                  student s=new student();
                  s.setname(rs.getString("name"));
                  s.setemail(rs.getString("email"));
                  s.setcourse(rs.getString("course"));
                  s.setphoneno(rs.getString("phoneno"));
                  s.settotalfee(rs.getInt("totalfee"));;
                  s.setfee(rs.getInt("fee"));
                  s.setdue(rs.getInt("due"));
                  s.setaddress(rs.getString("address"));
                 list.add(s);
                  
              }
              con.close();
      }catch(Exception e)
      { 
                  
         System.out.println(e.getMessage());

       }
      return list;
  }
    public static int delete(String name)
    {
        int status=0;
        try
        {
            Connection con=accountdbc.getcon();
            PreparedStatement ps=con.prepareStatement("DELETE from student WHERE name=?");
            ps.setString(1,name);
            status=ps.executeUpdate();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static int setimg(FileInputStream fis,String name)
    {
        System.out.println("name from set img :"+name);
        int status =0;
        try
        {
            Connection con=accountdbc.getcon();
            PreparedStatement ps=con.prepareStatement("insert into person values(?,?)");
            ps.setString(1,name);
            ps.setBinaryStream(2,(InputStream)fis,fis.available());
            status=ps.executeUpdate();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static  byte[] getimag(String name)
    {
        System.out.println("name from get img :"+name);
        byte[] img =null;
        try
        {
            Connection con=accountdbc.getcon();
            PreparedStatement ps=con.prepareStatement("select * from person where name =?");
            ps.setString(1, name);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                img=rs.getBytes("image");
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return img;
    }
   public static int updateimg(String name,FileInputStream fis)
   {
       int status=0;
       Connection con;
        try {
            con = accountdbc.getcon();
            PreparedStatement ps=con.prepareStatement("update person set image=? where name =?");
            ps.setString(1, name);
            status=ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(studentdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
            return status;
   }
   public static ArrayList<student> search(String name)
   {
       ArrayList<student> list=new ArrayList<student>();
       try
       {
           student s=new student();
           Connection con=accountdbc.getcon();
           PreparedStatement ps=con.prepareStatement("select *from student where name=?");
           ps.setString(1, name);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               s.setname(rs.getString("name"));
               s.setemail(rs.getString("email"));
               s.setcourse(rs.getString("course"));
               s.setphoneno(rs.getString("phoneno"));
               s.settotalfee(rs.getInt("totalfee"));
               s.setfee(rs.getInt("fee"));
               s.setdue(rs.getInt("due"));
               s.setaddress(rs.getString("address"));
               list.add(s);
           }
           
       }catch(Exception e)
       {
          System.out.println(e);
       }
       return list;
   }
}
