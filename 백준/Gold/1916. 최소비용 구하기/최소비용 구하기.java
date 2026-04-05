import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //도시까지 가는 최소비용
      //가중치 존재
      
      n = Integer.parseInt(br.readLine());
      m = Integer.parseInt(br.readLine());
      
      for(int i=0; i<=1000; i++){
        graph.add(new ArrayList<>());
      }
      
      StringTokenizer st;
      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        
        graph.get(start).add(new int[]{end,cost});
      }
      
      dist = new int[n+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      
      st = new StringTokenizer(br.readLine());
      
      int startCity = Integer.parseInt(st.nextToken());
      int endCity = Integer.parseInt(st.nextToken());
      
      int ans = dijkstra(startCity, endCity);
      System.out.println(ans);
    }
    
    static int dijkstra(int start, int end){
      //오름차순
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
      pq.add(new int[]{start, 0});
      
      while(!pq.isEmpty()) {
        int[] curr = pq.poll();
        int currNode = curr[0];
        int currCost = curr[1];
        
        if(currCost>dist[currNode]) continue;
        if(currNode == end) return currCost;
        
        for(int[] next : graph.get(currNode)) {
          int nextNode = next[0];
          int nextCost = currCost + next[1];
          
          if(nextCost<dist[nextNode]){
            dist[nextNode] = nextCost;
            pq.add(new int[]{nextNode, nextCost});
          }
        }
      }
      return -1;
    }
}