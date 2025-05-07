import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int m,n;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m];
        map = new int[n][m];
        
        for(int i=0; i<k; i++){
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          
          map[y][x] = 1;
        }
        
        int cnt = 0;
        for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
            if(visited[i][j] || map[i][j] != 1) continue;
            bfs(i,j);
            cnt++;
          }
        }
        System.out.println(cnt);
      }
  }
  
  static void bfs(int startY, int startX){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {startY, startX});
    visited[startY][startX] = true;
    
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int y = curr[0];
      int x = curr[1];
      
      for(int dir=0; dir<4; dir++){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx] || map[ny][nx] != 1) continue;
        q.add(new int[]{ny,nx});
        visited[ny][nx] = true;
      }
    }
  }
}