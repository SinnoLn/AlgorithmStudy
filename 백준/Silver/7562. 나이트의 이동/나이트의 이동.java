import java.util.*;
import java.io.*;

public class Main {
   static boolean[][] visited;
   static int[][] chess;
   static int endY, endX, n;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        chess = new int[n][n];
        visited = new boolean[n][n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        
        int ans = bfs(startY, startX);
        System.out.println(ans);
      }
  }
  
  static int bfs(int startY, int startX){
    Queue<int[]> q = new LinkedList<>();
    int[] dy = {-1,1,-2,2,-2,2,-1,1};
    int[] dx = {-2,-2,-1,-1,1,1,2,2};
    q.add(new int[]{startY, startX,0});
    visited[startY][startX] = true;
    
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int y = curr[0];
      int x = curr[1];
      int cnt = curr[2];
      
      if(endY == y && endX == x) return cnt;
      for(int dir=0; dir<8; dir++){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(visited[ny][nx]) continue;
        
        q.add(new int[]{ny,nx,cnt+1});
        visited[ny][nx] = true;
      }
    }
    return 0;
  }
}