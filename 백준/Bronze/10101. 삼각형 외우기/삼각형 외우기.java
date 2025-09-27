import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int a = Integer.parseInt(br.readLine());
      int b = Integer.parseInt(br.readLine());
      int c = Integer.parseInt(br.readLine());
      
      if(a+b+c != 180) System.out.println("Error");
      else{
        if(a==b && b==c && a==c) System.out.println("Equilateral");
        else if(a==b || b==c || a==c ) System.out.println("Isosceles");
        else System.out.println("Scalene");
      }
  }
}