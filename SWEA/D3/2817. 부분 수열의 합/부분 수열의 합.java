import java.util.*;
import java.io.*;

public class Solution {
    static int[] arr;
    static int cnt;
    static int n,k;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        cnt = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println("#"+t+" "+cnt);
      }
  }
  static void dfs(int idx, int sum){
    if(idx == n){
      if(sum == k) cnt++;
      return;
    }

    dfs(idx+1,sum);
    if(sum + arr[idx] <= k)
      dfs(idx+1,sum + arr[idx]);
  }
}