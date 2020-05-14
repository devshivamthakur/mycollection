/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
public class account {
  private String   name="",phoneno="",username="",password="";
  public account()
  {
    }
  public account(String name,String phoneno,String username,String password)
  {
      
      this.name=name;
      this.phoneno=phoneno;
      this.username=username;
      this.password=password;
      
    

  }
    public String getname()
    {
        return name;
    }
    public String getphoneno()
    {
        return phoneno;
    }
    public String getusername()
    {
        return username;
    }
    public String  getpassword()
    {
        return password;
    }
 public void setname(String name)
    {
       this.name= name;
    }
  public void setphoneno(String phoneno)
    {
       this.phoneno=phoneno;
    }
  public void setusername(String username)
  {
      this.username=username;
  }
  public void setpassword(String password)
  {
      this.password=password;
  }
   
 
    
}
