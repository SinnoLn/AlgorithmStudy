import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] dp = new int[n+1];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=1; i<n+1; i++){
        dp[i] = Integer.parseInt(st.nextToken());
      }
      
      int max = dp[1];
      int current = dp[1];
      //내가 구할건 최댓값
      //dp[i] 에서 나올수 있는 가장 큰 수 
      for(int i=2; i<n+1; i++){
        current = Math.max(dp[i], dp[i] + current);
        max = Math.max(max, current);
      }
      
      System.out.println(max);
  }
}