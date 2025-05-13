import java.util.*;
import java.io.*;

//인덱스 증가순
//숫자는 같거나 크게
//1000개
//Int범위의 숫자
public class Solution {
    static int[] num;
    static int[] dp;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t =1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<n; i++){
          dp[i] = 1;
        }
        
        int ans = 1;
        for(int i=0; i<n-1; i++){
          for(int j=i+1; j<n; j++){
            if(num[i] <= num[j]){
              dp[j] = Math.max(dp[j], dp[i]+1);
              ans =  Math.max(ans, dp[j]);
            }
          }
        }
        System.out.println("#"+t+" "+ans);
      }
  }
}