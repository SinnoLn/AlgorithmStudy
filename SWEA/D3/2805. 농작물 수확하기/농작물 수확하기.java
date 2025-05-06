import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int[][] farm = new int[n][n];
        
        for(int i=0; i<n; i++){
          String s = br.readLine();
          for(int j=0; j<n; j++){
            farm[i][j] = s.charAt(j)-'0';
          }
        }
        
        int ans = harvestCrops(farm, n);
        System.out.println("#"+t+" "+ans);
      }
  }
  static int harvestCrops(int[][] farm, int n){
    int mid = n/2;
    int sum = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(Math.abs(mid-i)+ Math.abs(mid-j) <= mid) sum+=farm[i][j];
      }
    }
    return sum;
  }
}