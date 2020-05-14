/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
public class student {
     private String name,email,phoneno,course,address;
    private int fee,due,totalfee;
    public student(String name,String email,String course,String phoneno,int totalfee,int fee,int due,String address)
    {
        this.name=name;
        this.email=email;
        this.phoneno=phoneno;
        this.fee=fee;
        this.course=course;
        this.due=due;
        this.address=address;
        this.totalfee=totalfee;
       
    }
    student()
    {
        
    }
 
public String getname() {
	return name;
}

public String getemail() {
	return email;
}
public String getcourse() {
	return course;
}

public int getfee() {
	return fee;
}
public String getphoneno()
{
    return phoneno;
    
}
public String getaddress()
{
    return address;
}
public int getdue() {
	return due;
}
public int gettotalfee()
{
    return totalfee;
}
public void setname(String name)
{
    this.name=name;
}
public void setemail(String email)
{
    this.email=email;
    
}
public void setcourse(String course)
{
    this.course=course;
}
public void setfee(int fee)
{
    this.fee=fee;
}
public void settotalfee(int totalfee)
{
    this.totalfee=totalfee;
}
public void setphoneno(String phoneno)
{
    this.phoneno=phoneno;
}
public void setdue(int due)
{
    this.due=due;
}
public void setaddress(String address)
{
    this.address=address;
}
{
    
}
}
