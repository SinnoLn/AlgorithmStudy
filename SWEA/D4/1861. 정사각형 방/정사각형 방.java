import java.util.*;
import java.io.*;

public class Solution {
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int[][] room;
    static int n;
    //이동하려는 방의 숫자가 현재 방의 숫자보다 1 큼
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        room = new int[n][n];
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            room[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        int minIdx = Integer.MAX_VALUE;
        int maxRoom = 1;
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            int count = bfs(i,j);
            if(count >= maxRoom){
              if(count == maxRoom) minIdx = Math.min(minIdx, room[i][j]);
              else{
                minIdx = room[i][j];
                maxRoom = count;
              }
            }
          }
        }
        System.out.println("#"+t+" "+minIdx + " " + maxRoom);
      }
  }
  
  static int bfs(int startY, int startX){
    Queue<int[]>q = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    
    q.add(new int[]{startY,startX});
    visited[startY][startX] = true;
    int cnt = 1;
    
    while(!q.isEmpty()){
       int[] curr = q.poll();
       int y = curr[0];
       int x = curr[1];

       for(int dir=0; dir<4; dir++){
         int ny = y + dy[dir];
         int nx = x + dx[dir];
         
         if(ny < 0|| nx < 0 || ny >= n || nx >= n) continue;
         if(visited[ny][nx]) continue;
         if((room[y][x]+1) != room[ny][nx]) continue;
         
         q.add(new int[]{ny,nx});
         visited[ny][nx] = true;
         cnt++;
       }
    }
    return cnt;
  }
}