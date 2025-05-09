import java.util.*;
import java.io.*;

public class Solution {
    static int[][] othello;
    //8방향 체크
    static int dy[] = {0,0,1,-1,1,-1,1,-1};
    static int dx[] = {-1,1,0,0,1,-1,-1,1};
    static int white;
    static int black;
    static int n,m;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        white = 2;
        black = 2;
        //1이 흑돌, 2가 백돌
        othello = new int[n][n];
        othello[n/2][n/2] = 2;
        othello[n/2-1][n/2-1] = 2;
        othello[n/2][n/2-1] = 1;
        othello[n/2-1][n/2] = 1;
        
        for(int i=0; i<m; i++){
          st = new StringTokenizer(br.readLine());
          int y = Integer.parseInt(st.nextToken())-1;
          int x = Integer.parseInt(st.nextToken())-1;
          int stone = Integer.parseInt(st.nextToken());
          if(stone == 1) black++;
          else white++;
          
          playOthello(y,x,stone);
        }
        System.out.println("#"+t+" "+black +" "+white);
      }
  }
  
  static void playOthello(int startY, int startX, int stone){
    othello[startY][startX] = stone;
    for(int dir=0; dir<8; dir++){
      List<int[]> path = new ArrayList<>();
      int ny = startY + dy[dir];
      int nx = startX + dx[dir];
      while(true){
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) break;
        if(othello[ny][nx] == 0) break;
        if(othello[ny][nx] == stone) {
          for(int[] p : path){
            othello[p[0]][p[1]] = stone;
            if(stone == 1) { black++; white--; }
            else { black--; white++; }
          }
          break;
        }
        else path.add(new int[]{ny,nx});
        ny += dy[dir];
        nx += dx[dir];
      }
    }
  }
}