import java.util.*;
import java.io.*;

//지뢰가 있는 칸을 제외한 다른 모든 칸의 숫자들이 표시되려면 
//최소 몇 번의 클릭을 해야 하는지 구하는 프로그램을 작성
public class Solution {
    static int dy[] = {0,1,0,-1,1,1,-1,-1};
    static int dx[] = {1,0,-1,0,-1,1,-1,1};
    static char[][] minesweeper;
    static int n;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        minesweeper = new char[n][n];
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++){
          String s = br.readLine();
          for(int j=0; j<n; j++){
            minesweeper[i][j] = s.charAt(j);
          }
        }
        
        int click = 0;
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            if(minesweeper[i][j] == '*') continue;
            if(!visited[i][j] && cntLandMine(i,j) == 0){
              bfs(i,j);
              click++;
            }
          }
        }
        
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            if(!visited[i][j] && minesweeper[i][j] == '.'){
                visited[i][j] = true;
                click++;
              }
          }
        }
        System.out.println("#"+t+" "+click);
      }
  }
  
  static void bfs(int startY, int startX){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{startY, startX});
    visited[startY][startX] = true;
    minesweeper[startY][startX] = '0';
    
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int y = curr[0];
      int x = curr[1];
      
      //0주위 숫자 까기
      for(int dir = 0; dir<8; dir++){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(visited[ny][nx]) continue;
        minesweeper[ny][nx] = (char)(cntLandMine(ny,nx) + '0');
      }
      
      //깐 숫자 중 0이 있는지 탐색
      for(int dir = 0; dir<8; dir++){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(visited[ny][nx] || minesweeper[ny][nx] == '*') continue;
        
        if(minesweeper[ny][nx] == '0'){
          q.add(new int[]{ny,nx});
          visited[ny][nx] = true;
        }
      }
    }
  }
  
  static int cntLandMine(int y, int x){
    int cnt = 0;
    for(int dir = 0; dir<8; dir++){
      int ny = y + dy[dir];
      int nx = x + dx[dir];
      
      if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
      if(minesweeper[ny][nx] == '*') cnt++;
    }
    return cnt;
  }
}