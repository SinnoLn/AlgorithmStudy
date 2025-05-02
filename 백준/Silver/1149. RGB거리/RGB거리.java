import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      //모든집의 색이 서로 달라야 한다.
      //N은 최대 1000, 최소 2
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[][] pay = new int[n][3];
      int[][] dp = new int[n][3];
      
      //빨강, 초록, 파랑
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        pay[i][0] = Integer.parseInt(st.nextToken());
        pay[i][1] = Integer.parseInt(st.nextToken());
        pay[i][2] = Integer.parseInt(st.nextToken());
      }
      
      int minVal = Integer.MAX_VALUE;
      
      dp[0][0] = pay[0][0];
      dp[0][1] = pay[0][1];
      dp[0][2] = pay[0][2];
      
      //dp[n] n번째 집까지 칠했을 때 최소비용
      for(int i=1; i<n; i++){
        //첫집 빨간색
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + pay[i][0];
        //첫집 초록색
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + pay[i][1];
        //첫집 파란색
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + pay[i][2];
      }
      
      System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
  }
}