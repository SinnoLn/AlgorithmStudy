import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      int dy[] = {0,1,0,-1};
      int dx[] = {1,0,-1,0};
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        int idx = 1;
        int dir = 0;
        int y = 0;
        int x = 0;
        map[y][x] = idx;
        visited[y][x] = true;
        while(idx < n*n){
          int ny = y + dy[dir];
          int nx = x + dx[dir];
          
          if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == true){
            dir = (dir+1)%4;
            continue;
          }
          
          y = ny;
          x = nx;
          idx++;
          map[ny][nx] = idx;
          visited[ny][nx] = true;
        }
        
        System.out.println("#"+t);
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            System.out.print(map[i][j] + " ");
          }
          System.out.println();
        }
      }
  }
}