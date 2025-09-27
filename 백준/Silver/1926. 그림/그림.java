import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n,m;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int ans,area;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      map = new int[n][m];
      visited = new boolean[n][m];
      
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(visited[i][j] || map[i][j] == 0) continue;
          ans++;
          bfs(i,j);
        }
      }
      
      System.out.println(ans);
      System.out.println(area);
  }
  
  static void bfs(int y, int x){
    Deque<int[]> dq = new ArrayDeque<>();
    dq.add(new int[]{y,x});
    visited[y][x] = true;
    
    int cnt = 1;
    while(!dq.isEmpty()){
      int curr[] = dq.poll();
      int cy = curr[0];
      int cx = curr[1];
      
      for(int dir=0; dir<4; dir++){
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx] || map[ny][nx] == 0) continue;
        
        dq.add(new int[]{ny,nx});
        visited[ny][nx] = true;
        cnt++;
      }
    }
    area = Math.max(area, cnt);
  }
}