import java.util.*;
import java.io.*;

public class Solution {
    static int n;
    static int[][] gomoku;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        gomoku = new int[n][n];
        
        for(int i=0; i<n; i++){
          String line = br.readLine();
          for(int j=0; j<n; j++){
            char c = line.charAt(j);
            if(c == 'o') gomoku[i][j] = 1;
          }
        }
        
        boolean isPossible = false;
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            if(gomoku[i][j] == 0) continue;
            if(findFiveStone(i,j)){
              isPossible = true;
              break;
            }
          }
        }
        
        if(isPossible) System.out.println("#"+t+" "+"YES");
        else System.out.println("#"+t+" "+"NO");
      }
  }
  
  //다섯 개 이상 연속한 부분
  static boolean findFiveStone(int y, int x){
    //우, 좌, 대각선1, 대각선2
    int[] dy ={0,1,1,-1};
    int[] dx ={1,0,1,1};
    int stone = gomoku[y][x];
    
    for(int dir=0; dir<4; dir++){
      int cnt = 1;
      int ny = y;
      int nx = x;
      
      while(true){
        ny+=dy[dir];
        nx+=dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) break;
        if(gomoku[ny][nx] != stone) break;
        cnt++;
      }
      
      if(cnt >= 5) return true;
    }
    return false;
  }
}