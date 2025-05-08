import java.util.*;
import java.io.*;
 
public class Solution {
    static int[] num;
    static int[][] dp;
    static int k,n;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
       
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
         
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
         
        //백트랙킹 (순서고려X) 100만
        //완전탐색 100만
        //dp? O(N × K) 2만
         
        dp = new int[n+1][k+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        int ans = dfs(0,0);
        System.out.println("#"+t+" "+ans);
      }
  }
   
  static int dfs(int idx, int sum){
    if(sum>k) return 0;
    if(idx == n){
      if(sum == k) return 1;
      else return 0;
    }
    
    if(dp[idx][sum] != -1) return dp[idx][sum];
    int res = 0;
    
    //포함하던가, 포함하지 않던가
    res+=dfs(idx+1,sum+num[idx]);
    res+=dfs(idx+1,sum);
    
    dp[idx][sum] = res;
    return res;
  }
}