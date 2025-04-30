import java.util.*;
import java.io.*;

public class Solution {
    static int[] arr;
    static int k,n,ans;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        ans = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println("#"+t+" "+ans);
      }
    }
    static void dfs(int idx, int sum){
        if(sum>k) return;
        if(sum == k){
          ans++;
          return;
        }
        if(idx == n) return;
        //넣거나
        dfs(idx+1, sum+arr[idx]);
        //안넣거나
        dfs(idx+1,sum);
      }
}