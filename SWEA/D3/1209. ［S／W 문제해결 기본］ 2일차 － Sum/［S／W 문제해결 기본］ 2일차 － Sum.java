import java.util.*;
import java.io.*;

public class Solution {
    static int[][] arr;
    static int ans;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        int test = Integer.parseInt(br.readLine());
        arr = new int[100][100];
        
        for(int i=0; i<100; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0;j<100; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        ans = 0;
        
        //행열 가장 큰값
        for(int i=0; i<100; i++){
          int sum1 = 0;
          int sum2 = 0;
          for(int j=0; j<100; j++){
            sum1+=arr[i][j];
            sum2+=arr[j][i];
          }
          ans = Math.max(ans, Math.max(sum1, sum2));
        }
        //대각선 가장 큰 값
        ans = Math.max(ans, maxSum(0,0,0));
        ans = Math.max(ans, maxSum(0,99,1));
        
        System.out.println("#"+test+" "+ans);
      }
  }
  static int maxSum(int y, int x, int dir){
    int dy[] = {1,1};
    int dx[] = {1,-1};
    int sum = arr[y][x];
    
    while(true){
      y+=dy[dir];
      x+=dx[dir];
      if(y < 0 || x < 0 || y >= 100 || x >= 100 ) break;
      sum+=arr[y][x];
    }
    
    return sum;
  }
}