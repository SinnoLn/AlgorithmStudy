import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      
      int fuc = b/a;
      System.out.println(fuc*3*c);
    }
}