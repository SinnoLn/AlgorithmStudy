import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    
    visited = new boolean[n+1];
    
    for(int i=0; i<=n; i++){
      graph.add(new ArrayList<>());
    }
    
    for(int line=0; line<m; line++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      
      graph.get(i).add(j);
      graph.get(j).add(i);
    }
    bfs(1);
    System.out.println(cnt);
  }
  
  static void bfs(int start){
    Queue<Integer> q = new LinkedList<>();
    visited[start] = true;
    q.add(start);
    
    while(!q.isEmpty()){
      int node = q.poll();
      for(int next : graph.get(node)){
        if(visited[next]) continue;
        visited[next] = true;
        q.add(next);
        cnt++;
      }
    }
  }
}