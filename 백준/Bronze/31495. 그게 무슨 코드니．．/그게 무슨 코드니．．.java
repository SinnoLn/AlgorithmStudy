import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      
      if (s == null || s.length() < 2) {
          System.out.println("CE");
          return;
      }
      
      if(s.charAt(0) != '"' || s.charAt(s.length()-1) != '"'){
        System.out.println("CE");
        return;
      }
      
      String result = s.substring(1,s.length()-1);
      if(result == "") System.out.println("CE");
      else System.out.println(result);
    }
}