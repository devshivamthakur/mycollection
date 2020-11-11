import java.net.URL;
import java.net.URLConnection;
class prac{
    public static void main(String [] args){
    try{
           URL url=new URL("https://google.com");
           URLConnection con=url.openConnection();
           con.connect();
           System.out.println("internet Connection Available");
    }catch(Exception e){
           System.out.println("No internet Connection ");
    }
}
}
