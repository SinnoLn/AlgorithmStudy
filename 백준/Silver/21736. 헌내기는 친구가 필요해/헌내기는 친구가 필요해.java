import java.util.*;
import java.io.*;

//O 빈공간
//X 벽
//I 도연이
//P 사람

//600 600
public class Main {
    static int n, m;
    static char[][] map;
    static int ans;
    static boolean[][] visited;
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      map = new char[n][m];
      visited = new boolean[n][m];
      int startX = 0;
      int startY = 0;
      
      for(int i=0; i<n; i++){
        String input = br.readLine();
        for(int j=0; j<m; j++){
          map[i][j] = input.charAt(j);
          if(map[i][j] == 'I'){
            startY = i;
            startX = j;
          }
        }
      }
      dfs(startY, startX);
      
      if(ans == 0) System.out.println("TT");
      else System.out.println(ans);
  }
  
  static void dfs(int y, int x){
    visited[y][x] = true;
    
    for(int dir=0; dir<4; dir++){
      int ny = y + dy[dir];
      int nx = x + dx[dir];
      
      if(ny<0 || nx<0 || ny>=n || nx>=m) continue;
      if(visited[ny][nx] || map[ny][nx] == 'X') continue;
      
      if(map[ny][nx] == 'P') ans++;
      visited[ny][nx] = true;
      dfs(ny, nx);
    }
  }
}