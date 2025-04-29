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
          String s = br.readLine();
          for(int j=0; j<n; j++){
            farm[i][j] = s.charAt(j) - '0';
          }
        }
        int ans = cropHarvest(n);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int cropHarvest(int n) {
    int sum = 0;
    int center = n / 2;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (Math.abs(i - center) + Math.abs(j - center) <= center) {
                sum += farm[i][j];
            }
        }
    }
    return sum;
  }
}