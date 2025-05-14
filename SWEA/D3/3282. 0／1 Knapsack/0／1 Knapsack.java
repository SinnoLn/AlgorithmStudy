import java.util.*;
import java.io.*;

public class Solution {
   static class Item {
     int volume;
     int value;
     
     public Item(int volume, int value){
       this.volume = volume;
       this.value = value;
     }
   }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Item[] items = new Item[n];
        
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          int v = Integer.parseInt(st.nextToken());
          int c = Integer.parseInt(st.nextToken());
          
          items[i] = new Item(v,c);
        }
        
        //1부터 i까지 사용, 부피 j일때의 최대 가격
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
          int vol = items[i-1].volume;
          int val = items[i-1].value;
          for(int j=0; j<=k; j++){
            if(j>=vol) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-vol]+val);
            else dp[i][j] = dp[i-1][j];
          }
        }
        System.out.println("#"+t+" "+dp[n][k]);
      }
  }
}