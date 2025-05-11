import java.util.*;
import java.io.*;

public class Solution {
    static int[] array;
    static boolean[] dp;
    static int n;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[n];
        int total = 0;

        for(int i=0; i<n; i++) {
          array[i] = Integer.parseInt(st.nextToken());
          total += array[i];
        }
        
        dp = new boolean[total+1];
        dp[0] = true;
        
        for(int score : array) {
          for(int i = total; i>=score; i--){
            if(dp[i-score]) dp[i] = true;
          }
        }
        
        int count = 0;
        for(boolean possible : dp){
          if(possible) count++;
        }
      
        System.out.println("#" + t + " " + count); 
      }
  }
}