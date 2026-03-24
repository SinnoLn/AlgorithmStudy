import java.util.*;
import java.io.*;

//다익스트라 알고리즘
public class Main {
    static int[] dy = {0,1,0,-1};
    static int[] dx = {-1,0,1,0};
    static int[][] map;
    static int[][] dist;
    static int n;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //최대 125*125
      //최소 잃는 금액
      int stage = 1;
      while(true){
        n = Integer.parseInt(br.readLine());
        if(n == 0) return;
        
        map = new int[n][n];
        dist = new int[n][n];
        
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
            dist[i][j] = Integer.MAX_VALUE;
          }
        }
        int ans = dijkstra(0,0);
        System.out.println("Problem "+stage+": "+ans);
        stage++;
      }
    }
    
    static int dijkstra(int startY, int startX) {
      //y,x,cost
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
      
      dist[startY][startX] = map[startY][startX];
      pq.add(new int[]{startY,startX,map[startY][startX]});
      
      while(!pq.isEmpty()){
        int[] curr = pq.poll();
        int y = curr[0];
        int x = curr[1];
        int cost = curr[2];
        
        if(cost > dist[y][x]) continue;
        if(y == n-1 && x == n-1) return cost;
        
        for(int dir=0; dir<4; dir++){
          int ny = y + dy[dir];
          int nx = x + dx[dir];
          
          if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
          
          int nextCost = cost + map[ny][nx];
          if(nextCost>=dist[ny][nx]) continue;
          
          dist[ny][nx] = nextCost;
          pq.add(new int[]{ny,nx,nextCost});
        }
      }
      return -1;
    }
}