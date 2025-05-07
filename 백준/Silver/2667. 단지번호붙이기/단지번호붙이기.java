import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int n;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      
      map = new int[n][n];
      for(int i=0; i<n; i++){
        String s = br.readLine();
        for(int j=0;j<n;j++){
          map[i][j] = s.charAt(j)-'0';
        }
      }
      visited = new boolean[n][n];
      
      int cnt = 0;
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          if(visited[i][j]||map[i][j] != 1) continue;
          bfs(i,j);
          cnt++;
        }
      }
      System.out.println(cnt);
      Collections.sort(ans);
      for(int i : ans) System.out.println(i);
  }
  
  static void bfs(int startY, int startX){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{startY,startX});
    visited[startY][startX] = true;
    
    int sum = 1;
    while(!q.isEmpty()){
        int[] curr = q.poll();
        int y = curr[0];
        int x = curr[1];
        
        for(int dir=0; dir<4; dir++){
          int ny = y + dy[dir];
          int nx = x + dx[dir];
          
          if(ny < 0 || nx < 0 || ny >= n || nx >=n) continue;
          if(visited[ny][nx] || map[ny][nx] != 1) continue;
          q.add(new int[]{ny, nx});
          visited[ny][nx] = true;
          sum++;
        }
      }
      ans.add(sum);
  }
}