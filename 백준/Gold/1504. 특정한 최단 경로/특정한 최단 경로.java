import java.util.*;
import java.io.*;

public class Main {
    static int n,e;
    static int[] dist;
    static int v1,v2;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());
      
      for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
      }
      
      for(int i=0; i<e; i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        graph.get(a).add(new int[]{b,c});
        graph.get(b).add(new int[]{a,c});
      }
      
      st = new StringTokenizer(br.readLine());
      v1 = Integer.parseInt(st.nextToken());
      v2 = Integer.parseInt(st.nextToken());
      
      int r1 = dijkstra(1,v1);
      int r2 = dijkstra(v1,v2);
      int r3 = dijkstra(v2,n);
      
      int r4 = dijkstra(1,v2);
      int r5 = dijkstra(v1,n);
      
      int ans = cntAns(r1,r2,r3,r4,r5);
      System.out.println(ans);
    }
    
    static int dijkstra(int start, int end){
      dist = new int[n+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
      pq.add(new int[]{start, 0});
      dist[start] = 0;
      
      while(!pq.isEmpty()){
        int[] curr = pq.poll();
        int currNode = curr[0];
        int currCost = curr[1];
        
        if(currCost>dist[currNode]) continue;
        if(currNode == end) return currCost;
        
        for(int[] next : graph.get(currNode)){
          int nextNode = next[0];
          int nextCost = next[1] + currCost;
          
          if(nextCost>=dist[nextNode]) continue;
          dist[nextNode] = nextCost;
          pq.add(new int[]{nextNode,nextCost});
        }
      }
      
      return -1;
    }
    
    static int cntAns(int r1, int r2, int r3, int r4, int r5){
      if(r2 == -1) return -1;
      
      int sum1 = 0;
      int sum2 = 0;
      sum1 = (r1 == -1 || r3 == -1) ? -1 : r1+r3;
      sum2 = (r4 == -1 || r5 == -1) ? -1 : r4+r5;
      
      if(sum1 == -1 && sum2 == -1) return -1;
      else if(sum1 == -1) return r2 + sum2;
      else if(sum2 == -1) return r2 + sum1;
      else return r2 + Math.min(sum1, sum2);
    }
}