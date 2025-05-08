import java.util.*;
import java.io.*;

public class Solution {
    static int[][] map = new int[100][100];
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int t=1; t<=10; t++){
      int test = Integer.parseInt(br.readLine());
      
      for(int i=0; i<100; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<100; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      int sum1 = calSumCA();
      int sum2 = calSumD(0,0,0);
      int sum3 = calSumD(0,99,1);
      
      int ans = Math.max(sum1, Math.max(sum2, sum3));
      System.out.println("#"+test+" "+ans);
    }
  }
  
  static int calSumCA(){
    //행 열 탐색
    int max = 0;
    for(int i=0; i<100; i++){
      int sum1 = 0;
      int sum2 = 0;
      for(int j=0; j<100; j++){
        sum1+=map[i][j];
        sum2+=map[j][i];
      }
      max = Math.max(Math.max(sum1,sum2),max);
    }
    return max;
  }
  
  static int calSumD(int y, int x, int dir){
    int dy[] = {1,1};
    int dx[] = {1,-1};
    
    int sum = map[y][x];
    //대각선 탐색
    while(true){
      y += dy[dir];
      x += dx[dir];
      
      if(y<0 || x<0 || y>=100 || x>=100) break;
      sum+=map[y][x];
    }
    
    return sum;
  }
}