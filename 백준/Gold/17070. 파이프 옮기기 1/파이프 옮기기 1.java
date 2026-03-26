import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[][] map = new int[n][n];
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      //모든 이동 경우의 수
      //dp
      int[][][] dp = new int[n][n][3]; //방향 (0,1,2) 가로, 세로, 대각선
      dp[0][1][0] = 1;
      
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          // //가로 이동
          // dp[i][j][0]+=dp[i][j-1][0];
          // dp[i][j][2]+=dp[i][j-1][0];
          
          // //세로 이동
          // dp[i][j][1]+=dp[i-1][j][1];
          // dp[i][j][2]+=dp[i-1][j][1];
          
          // //대각선 이동
          // dp[i][j][0]+=dp[i][j-1][2];
          // dp[i][j][1]+=dp[i-1][j][2];
          // dp[i][j][2]+=dp[i-1][j-1][2];
          
          if(map[i][j] == 1) continue;
          
          if(j-1 >= 0){
             //가로 이동
            dp[i][j][0]+=dp[i][j-1][0];
            dp[i][j][0]+=dp[i][j-1][2];
          }
          
          if(i-1 >= 0){
            //세로 이동
            dp[i][j][1]+=dp[i-1][j][1];
            dp[i][j][1]+=dp[i-1][j][2];
          }
          
          if(i-1 >= 0 && j-1 >=0){
            if(map[i][j-1] == 1 || map[i-1][j] == 1) continue;
            //대각선 이동
            dp[i][j][2]+=dp[i-1][j-1][0];
            dp[i][j][2]+=dp[i-1][j-1][1];
            dp[i][j][2]+=dp[i-1][j-1][2];
          }
        }
      }
      
      System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
    }
}