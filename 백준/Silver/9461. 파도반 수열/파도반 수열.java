import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      long[] dp = new long[101];
      dp[1] = 1;
      dp[2] = 1;
      dp[3] = 1;
      dp[4] = 2;
      for(int i=5; i<101; i++){
        dp[i] = dp[i-1] + dp[i-5];
      }
      
      for(int t=0; t<test; t++){
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
      }
  }
}