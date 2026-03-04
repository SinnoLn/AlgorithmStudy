import java.util.*;
import java.io.*;

public class Main {
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int[][] map;
    static boolean[][][] visited;
    static int n,m,ans;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      map = new int[n][m];
      visited = new boolean[n][m][2];
      
      for(int i=0; i<n; i++){
        String input = br.readLine();
        for(int j=0; j<m; j++){
          map[i][j] = input.charAt(j)-'0';
        }
      }
      
      //1,1에서 m,n까지 이동
      //최단 경로
      //최대 100만개
      //1이 벽
      int ans = bfs(0,0);
      System.out.println(ans);
    }
    
    static int bfs(int startY, int startX){
      Deque<int[]> dq = new ArrayDeque<>();
      dq.add(new int[]{startY,startX, 0,1});
      visited[startY][startX][0] = true;

      while(!dq.isEmpty()){
        int[] curr = dq.poll();
        int y = curr[0];
        int x = curr[1];
        int broken = curr[2];
        int dist = curr[3];
        
        if(y == n-1 && x == m-1) return dist;
        
        for(int dir=0; dir<4; dir++){
          int ny = y + dy[dir];
          int nx = x + dx[dir];
          
          if(ny<0 || nx<0 || ny>=n || nx>= m) continue;
          
          // 벽이 아니고 방문하지 않았다면
          if(map[ny][nx] == 0 && !visited[ny][nx][broken]) {
            visited[ny][nx][broken] = true;
            dq.add(new int[]{ny, nx, broken, dist+1});
          }
          // 벽이고 아직 안부쉈다면
          else if(map[ny][nx] == 1 && broken == 0 && !visited[ny][nx][1]) {
            dq.add(new int[]{ny,nx, 1, dist+1});
            visited[ny][nx][1] = true;
          }
        }
      }
      return -1;
    }
}