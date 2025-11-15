import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      double a = Double.parseDouble(st.nextToken());
      double b = Double.parseDouble(st.nextToken());
      double c = Double.parseDouble(st.nextToken());
      
      double sum1 = a*b/c;
      double sum2 = a/b*c;
      
      double ans = Math.max(sum1,sum2);
      System.out.println((int)ans);
  }
}