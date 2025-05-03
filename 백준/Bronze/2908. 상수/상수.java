import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      
      String a = sc.next();
      String b = sc.next();
      
      int an =0;
      int bn =0;
      
      for(int i=a.length()-1; i>-1; i--){
        an+=a.charAt(i)-'0';
        an*=10;
        
        bn+=b.charAt(i)-'0';
        bn*=10;
      }
      
      if(an>bn) System.out.println(an/10);
      else System.out.println(bn/10);
      sc.close();
  }
}