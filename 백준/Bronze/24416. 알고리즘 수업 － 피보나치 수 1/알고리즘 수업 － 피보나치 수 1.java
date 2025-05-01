import java.util.*;
import java.io.*;

public class Main {
  static int n,cnt1,cnt2;
  static int[] dp;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      dp = new int[n+1];
      fib(n);
      fibonacci(n);
      
      System.out.println(cnt1 + " " + cnt2);
  }
  
  static int fib(int n){
    if(n == 1 || n ==2) {
      cnt1++;
      return 1;
    }
    else return (fib(n-1) + fib(n-2));
  }
  
  static void fibonacci(int n){
    dp[1] = 1;
    dp[2] = 2;
    
    for(int i=3; i<=n; i++){
      cnt2++;
      dp[i] = dp[i-1] + dp[i-2];
    }
  }
}