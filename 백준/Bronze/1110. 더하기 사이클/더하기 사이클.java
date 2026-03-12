import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int count = 0;
      
      int num = n;
      while (true) {
        int sum = (num / 10) + (num % 10);
        num = (num % 10) * 10 + (sum % 10);
        count++;
        if (num == n) break;
      }
      System.out.println(count);
    }
}