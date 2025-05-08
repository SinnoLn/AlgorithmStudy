import java.util.*;
import java.io.*;

public class Solution {
    static int[] num;
    static int k,n;
    static int cnt;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        num = new int[n];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
        
        //백트랙킹 (순서고려X) 100만
        //완전탐색 100만
        //dp? O(N × K) 2만
        
        // int[][] dp = new int[][];
        dfs(0,0);
        System.out.println("#"+t+" "+cnt);
      }
  }
  
  static void dfs(int idx, int sum){
    if(idx == n){
      if(sum == k) cnt++;
      return;
    }
    //포함하던가, 포함하지 않던가
    dfs(idx+1,sum+num[idx]);
    dfs(idx+1,sum);
  }
}