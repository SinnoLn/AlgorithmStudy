import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n,m;
    static int dist[];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
      }
      
      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
      
      int bestNode = 1;
      int bestSum = Integer.MAX_VALUE;
      
      for(int node = 1; node<=n; node++){
        int curSum = bfs(node);
        if(curSum < bestSum || (curSum == bestSum && node < bestNode)) {
          bestSum = curSum;
          bestNode = node;
        }
      }
      
      System.out.println(bestNode);
  }
  
  static int bfs(int node){
    int dist[] = new int[n+1];
    Arrays.fill(dist, -1);
    
    Deque<Integer> q = new ArrayDeque<>();
    dist[node] = 0;
    q.add(node);
    
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int next: graph.get(cur)){
        if(dist[next] == -1){
          dist[next] = dist[cur] + 1;
          q.add(next);
        }
      }
    }
    
    int sum = 0;
    for(int v=1; v<=n; v++) sum += dist[v];
    return sum;
  }
}