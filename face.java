import java.util.*;
public class face
{
    Random  r=new Random();
        String s1="0123456789";
        public String otp(int size)
        {
            String s="";
            for(int i=0;i<size;i++)
            {
                s=s+s1.charAt(r.nextInt(10));
            }
            return s;
        }
    public static void main(String[] args)
    {
        face f=new face();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of otp");
        int size=sc.nextInt();
        System.out.println("otp : "+f.otp(size));
        
    }
}