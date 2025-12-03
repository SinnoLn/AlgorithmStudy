import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int[] t = new int[n];
      int[] p = new int[n];
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        t[i] = Integer.parseInt(st.nextToken());
        p[i] = Integer.parseInt(st.nextToken());
      }
      
      int[] dp = new int[n+1];
      
      for(int i=n-1; i>=0; i--){
        int nextDay = i + t[i];
        
        //상담 가능
        if(nextDay<=n) dp[i] = Math.max(p[i] + dp[nextDay], dp[i+1]);
        else dp[i] = dp[i+1];
      }
      
      System.out.println(dp[0]);
  }
}