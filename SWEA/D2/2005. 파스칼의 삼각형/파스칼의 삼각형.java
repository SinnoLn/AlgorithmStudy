import java.io.*;
import java.util.*;

public class Solution {
    static final int N = 10;
    static int[][] dp = new int[N+1][N+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        makePascal(N);
        
        for(int t=1; t<=test; t++){
          int n = Integer.parseInt(br.readLine());
          System.out.println("#"+t);
          for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
              bw.write(dp[i][j] + " ");
            }
            bw.write("\n");
          }
          bw.flush();
        }
        bw.close();
        br.close();
    }
    static void makePascal(int n){
      for(int i=1; i<=n; i++){
        dp[i][1] = 1;
        dp[i][i] = 1;
      }
      
      for(int i=3; i<=n; i++){
        for(int j=2; j<=(i-1); j++){
          dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
      }
    }
}