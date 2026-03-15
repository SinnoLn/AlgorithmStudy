import java.util.*;
import java.io.*;

public class Main {
   static int n;
   static int[] sharkPos;
   static boolean[][] visited;
   static int[][] map;
   static int sharkSize = 2;
   static int eatCnt = 0;
   static int totalTime = 0;
   static int[] dy = {0,1,0,-1};
   static int[] dx = {1,0,-1,0};
   static class Fish {
     int dis; //거리
     int y;
     int x;
     
     public Fish(int y, int x, int dis){
       this.y = y;
       this.x = x;
       this.dis = dis;
     }
   }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      n = Integer.parseInt(br.readLine());
      map = new int[n][n];
      sharkPos = new int[2];
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
          if(map[i][j] == 9){
            sharkPos[0] = i;
            sharkPos[1] = j;
            map[i][j] = 0;
          }
        }
      }
      
      while(true){
        Fish cur = bfs();
        if(cur == null) break;
        
        totalTime += cur.dis;
        sharkPos[0] = cur.y;
        sharkPos[1] = cur.x;
        map[sharkPos[0]][sharkPos[1]] = 0;
        
        eatCnt++;
        
        if(eatCnt == sharkSize){
          sharkSize++;
          eatCnt = 0;
        }
      }
      
      System.out.println(totalTime);
    }
    
    static Fish bfs(){
      visited = new boolean[n][n];
      Deque<int[]> dq = new ArrayDeque<>();
      
      dq.add(new int[]{sharkPos[0], sharkPos[1], 0});
      visited[sharkPos[0]][sharkPos[1]] = true;
      
      List<Fish> tmp = new ArrayList<>();
      int minDist = Integer.MAX_VALUE;
      
      while(!dq.isEmpty()) {
        int[] cur = dq.poll();
        int y = cur[0];
        int x = cur[1];
        int dist = cur[2];
        
        if(dist>minDist) continue;
        
        if(map[y][x] > 0 && map[y][x] < sharkSize){
          tmp.add(new Fish(y,x,dist));
          minDist = dist;
          continue;
        }
        
        for(int dir = 0; dir<4; dir++){
          int ny = y + dy[dir];
          int nx = x + dx[dir];
          
          if(ny<0 || nx<0 || ny >= n || nx >= n) continue;
          if(visited[ny][nx]) continue;
          
          if(map[ny][nx] > sharkSize) continue;
          
          visited[ny][nx] = true;
          dq.add(new int[]{ny,nx,dist+1});
        }
      }
      
      if(tmp.isEmpty()) return null;
      
      tmp.sort((a,b) ->{
        if(a.dis != b.dis) return a.dis - b.dis;
        if(a.y != b.y) return a.y - b.y;
        return a.x-b.x;
      });
      
      return tmp.get(0);
    }
}