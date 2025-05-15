import java.util.*;
import java.io.*;

public class Solution {
    static int[][] maze;
    static boolean[][] visited;
    static int[] sPosition;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t<=10; t++){
        int test = Integer.parseInt(br.readLine());
        maze = new int[16][16];
        visited = new boolean[16][16];
        sPosition = new int[2];

        for(int i=0; i<16; i++){
          String s = br.readLine();
          for(int j=0; j<16; j++){
            maze[i][j] = s.charAt(j)-'0';
            if(maze[i][j] == 2){
              sPosition[0] = i;
              sPosition[1] = j;
            }
          }
        }
        int ans = bfs();
        System.out.println("#"+test+" "+ans);
      }
  }
  
  static int bfs(){
    int dy[] = {0,1,0,-1};
    int dx[] = {1,0,-1,0};
    
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sPosition[0], sPosition[1]});
    visited[sPosition[0]][sPosition[1]] = true;
    
    while(!q.isEmpty()){
      int curr[] = q.poll();
      int y = curr[0];
      int x = curr[1];
      if(maze[y][x] == 3) return 1;
      
      for(int dir=0; dir<4; dir++){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny < 0 || nx < 0 || nx >= 16 || ny >= 16) continue;
        if(visited[ny][nx] || maze[ny][nx] == 1) continue;
        
        q.add(new int[]{ny, nx});
        visited[ny][nx] = true;
      }
    }
    return 0;
  }
}