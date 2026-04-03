import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String input = br.readLine();
      String[] arr = {"pi","ka","chu"};
      
      int i = 0;
      
      while (i < input.length()) {
          if (i + 1 < input.length() && input.startsWith("pi", i)) {
              i += 2;
          } else if (i + 1 < input.length() && input.startsWith("ka", i)) {
              i += 2;
          } else if (i + 2 < input.length() && input.startsWith("chu", i)) {
              i += 3;
          } else {
              System.out.println("NO");
              return;
          }
      }
      System.out.println("YES");
    }
}