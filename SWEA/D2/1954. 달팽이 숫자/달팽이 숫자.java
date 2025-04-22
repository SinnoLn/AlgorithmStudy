import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int dy[] = {0,1,0,-1};
      int dx[] = {1,0,-1,0};
      int t = Integer.parseInt(br.readLine());
      for(int test = 1; test<=t; test++){
        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[n][n];
        int[][] map = new int[n][n];
        int index = 1;
        int y = 0;
        int x = 0;
        int dir = 0;
        visited[y][x] = true;
        map[y][x] = index;
        index++;
        
        while(index < n*n+1){
          int ny = y + dy[dir];
          int nx = x + dx[dir];
          
          if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]){
            dir = (dir+1)%4;
            ny = y + dy[dir];
            nx = x + dx[dir];
          }
          
          map[ny][nx] = index;
          visited[ny][nx] = true;
          index++;
          
          y = ny;
          x = nx;
        }
        
        System.out.println("#"+test);
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            System.out.printf(map[i][j]+" ");
          }
          System.out.println();
        }
      }
  }
}