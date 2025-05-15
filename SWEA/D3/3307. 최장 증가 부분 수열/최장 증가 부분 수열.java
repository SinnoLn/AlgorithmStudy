import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<n; i++) dp[i] = 1;
        
        int max = 0;
        for(int i=0; i<n-1; i++){
          for(int j=i+1; j<n; j++){
            if(num[j] >= num[i]){
              dp[j] = Math.max(dp[j], dp[i]+1);
              max = Math.max(max, dp[j]);
            }
          }
        }
        System.out.println("#"+t+" "+max);
      }
  }
}