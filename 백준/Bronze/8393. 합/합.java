import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int sum=0;
      for(int i=1; i<=n; i++) sum+=i;
      
      System.out.println(sum);
  }
}