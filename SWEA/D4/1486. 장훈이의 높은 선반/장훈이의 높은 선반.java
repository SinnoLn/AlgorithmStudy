import java.util.*;
import java.io.*;

public class Solution {
    static int[] height;
    static int ans;
    static int n,b;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        height = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          height[i] = Integer.parseInt(st.nextToken());
        }
        
        ans = 2000000;
        dfs(0,0);
        System.out.println("#"+t+" "+(ans-b));
      }
  }
  
  //부분집합
  //b이상의 가장 작은 수
  static void dfs(int idx, int sum){
    if(idx == n){
      if(sum>=b) ans = Math.min(ans, sum);
      return;
    }
    
    dfs(idx+1, sum+height[idx]);
    dfs(idx+1, sum);
  }
}