import java.util.*;
import java.io.*;

public class Solution {
    static int[][] farm;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        farm = new int[n][n];
        
        for(int i=0; i<n; i++){
          String input = br.readLine();
          for(int j=0; j<n; j++){
            farm[i][j] = input.charAt(j)-'0';
          }
        }
        
        int ans = getHarvest(n);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int getHarvest(int n){
    int cnt = 0;
    int mid = n/2;
    
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(Math.abs(mid-i) + Math.abs(mid-j) <= mid) cnt+=farm[i][j];
      }
    }
    
    return cnt;
  }
}