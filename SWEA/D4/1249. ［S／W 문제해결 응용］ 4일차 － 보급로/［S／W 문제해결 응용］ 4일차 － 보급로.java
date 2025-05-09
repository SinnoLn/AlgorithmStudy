import java.util.*;
import java.io.*;

public class Solution {
    static class Node implements Comparable<Node> {
      int y,x;
      int cost;
      public Node(int y, int x, int cost){
        this.y = y;
        this.x = x;
        this.cost = cost;
      }
      public int compareTo(Node o){
        return this.cost - o.cost;
      }
    }
    
    static int[][] map;
    static int[][] dist;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];
        
        for(int i=0; i<n; i++){
          String s = br.readLine();
          for(int j=0; j<n ;j++){
            map[i][j] = s.charAt(j)-'0';
            dist[i][j] = Integer.MAX_VALUE;
          }
        }
        
        dijkstra();
        System.out.println("#"+t+" "+dist[n-1][n-1]);
      }
  }
  
  static void dijkstra(){
    PriorityQueue<Node>pq = new PriorityQueue<>();
    pq.add(new Node(0,0,0));
    dist[0][0] = 0;
    
    while(!pq.isEmpty()){
      Node curr = pq.poll();
      if(curr.cost > dist[curr.y][curr.x]) continue;
      
      for(int dir=0; dir<4; dir++){
        int ny = curr.y + dy[dir];
        int nx = curr.x + dx[dir];
        
        if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        
        int nextCost = curr.cost + map[ny][nx];
        if(nextCost < dist[ny][nx]){
          dist[ny][nx] = nextCost;
          pq.add(new Node(ny,nx,nextCost));
        }
      }
    }
  }
}