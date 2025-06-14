import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int ans = calFactorial(n);
      System.out.println(ans);
  }
  
  static int calFactorial(int n){
    if(n == 1) return 1;
    if(n == 0) return 0;
    return calFactorial(n-1) + calFactorial(n-2);
  }
}