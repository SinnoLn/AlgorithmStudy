import java.util.*;
import java.io.*;

//n*m
//최대로 가져올 수 있는 사탕의 개수
//격자탐색이나 dp
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      int[][] candy = new int[n][m];
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
          candy[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      //오른쪽, 아래, 오른쪽 아래 3방향으로 이동 가능
      //각 위치에서의 최대 사탕 
      int[][] dp = new int[n][m];
      dp[0][0] = candy[0][0];
      
      //초기화
      for(int i=1; i<m; i++) dp[0][i] = dp[0][i-1] + candy[0][i];
      for(int j=1; j<n; j++) dp[j][0] = dp[j-1][0] + candy[j][0];
      
      //로직 시작
      for(int i=1; i<n; i++){
        for(int j=1; j<m; j++){
          dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1])) + candy[i][j];
        }
      }
      
      System.out.println(dp[n-1][m-1]);
  }
}