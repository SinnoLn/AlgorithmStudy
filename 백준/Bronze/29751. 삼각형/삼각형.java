import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      double w = sc.nextDouble();
      double h = sc.nextDouble();
      
      Double sum = w*h*(0.5);
      System.out.println(sum);
    }
}