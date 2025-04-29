import java.util.*;
import java.io.*;

public class Solution {
    // 오른쪽 아래, 왼쪽 아래
    static int dy[] = {1,1};
    static int dx[] = {1,-1};
    static int[][] map = new int[100][100];
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t <= 10; t++){
        int test = Integer.parseInt(br.readLine());
        for(int i=0; i<100; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<100; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        int ans = 0;
        //행열 최댓값
        for(int i=0; i<100; i++){
          int sum1 = 0;
          int sum2 = 0;
          for(int j=0; j<100; j++){
            sum1+=map[i][j];
            sum2+=map[j][i];
          }
          ans = Math.max(ans,Math.max(sum1,sum2));
        }
        
        //대각선 최댓값
        ans = Math.max(ans, maxSum(0,0,0));
        ans = Math.max(ans, maxSum(99,0,1));
        
        System.out.println("#"+test+" " +ans);
      }
  }
  
  static int maxSum(int x, int y, int dir){
    int sum = map[y][x];
    while(true){
          y += dy[dir];
          x += dx[dir];
          if(x < 0 || y < 0 || x >= 100 || y >= 100 ) break;
          sum += map[y][x];
    }
    return sum;
  }
}