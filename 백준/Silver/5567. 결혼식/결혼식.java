import java.util.*;
import java.io.*;

public class Main {
  static List<List<Integer>> graph = new ArrayList<>();
  static boolean[] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      
      for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
      }
      
      visited = new boolean[n+1];
      
      for(int i=0; i<m; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
      
      int ans = bfs(1);
      System.out.println(ans);
  }
  
  //친구의 친구까지만
  static int bfs(int start){
    Queue<Integer> q = new LinkedList<>();
    int cnt = 0;
    int[] dist = new int[visited.length];

    q.add(start);
    visited[start] = true;
    
    while(!q.isEmpty()){
      int node = q.poll();
      if (dist[node] == 2) continue;
       
      for(int next : graph.get(node)){
        if(visited[next]) continue;
        int nd = dist[node] + 1;
        if (nd > 2) continue;   
            
        visited[next] = true;
        dist[next] = nd;
        q.add(next);
        cnt++;
      }
    }
    return cnt;
  }
}