import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        int ans = 0;
        for(int i=0; i<n-m+1; i++){
          for(int j=0; j<n-m+1; j++){
            
            int sum = 0;
            for(int y=i; y<i+m; y++){
              for(int x=j; x<j+m; x++){
                sum+=map[y][x];
              }
            }
            ans = Math.max(ans, sum);
          }
        }
        System.out.println("#"+t+" "+ans);
      }
  }
}