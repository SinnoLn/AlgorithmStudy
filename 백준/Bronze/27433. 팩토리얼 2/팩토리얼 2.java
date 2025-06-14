import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      long ans = calFactorial(n);
      System.out.println(ans);
  }
  
  static long calFactorial(int n){
    if(n <= 1) return 1;
    return n * calFactorial(n-1);
  }
}