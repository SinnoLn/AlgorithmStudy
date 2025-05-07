import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dy={0,1,0,-1};
    static int[] dx={1,0,-1,0};
    static int n,m;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      visited = new boolean[n][m];
      map = new int[n][m];
      
      for(int i=0; i<n; i++){
        String s = br.readLine();
        for(int j=0; j<m; j++){
          map[i][j] = s.charAt(j)-'0';
        }
      }
      int ans = bfs(0,0);
      System.out.println(ans);
  }
  
  static int bfs(int startY, int startX){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{startY, startX, 1});
    visited[startY][startX] = true;
    
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int y = curr[0];
      int x = curr[1];
      int cnt = curr[2];
      
      if(y == (n-1) && x == (m-1)) return cnt;
      
      for(int dir=0; dir<4; dir++){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx] || map[ny][nx] != 1) continue;
        q.add(new int[] {ny, nx, cnt+1});
        visited[ny][nx] = true;
      }
    }
    return 0;
  }
}