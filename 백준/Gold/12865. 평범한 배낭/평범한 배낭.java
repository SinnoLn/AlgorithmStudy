import java.util.*;
import java.io.*;

public class Main {
    static int[] weight;
    static int[] value;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      weight = new int[n];
      value = new int[n];
      
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        weight[i] = Integer.parseInt(st.nextToken());
        value[i] = Integer.parseInt(st.nextToken());
      }
      
      int[] dp = new int[k+1];
      for(int i=0; i<n; i++){
        int w = weight[i];
        int v = value[i];
        
        for(int j=k; j>=w; j--){
          dp[j] = Math.max(dp[j], dp[j-w]+v);
        }
      }
      
      int ans = 0;
      for(int i : dp){
        ans = Math.max(ans, i);
      }
      System.out.println(ans);
  }
}