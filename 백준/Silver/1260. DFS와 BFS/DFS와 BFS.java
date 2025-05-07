import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      
      for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
      }
      
      for(int line=0; line<m; line++){
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        
        graph.get(i).add(j);
        graph.get(j).add(i);
      }
      for(List<Integer> neighbor : graph){
        Collections.sort(neighbor);
      }
      
      visited = new boolean[n+1];
      dfs(r);
      bw.flush();
      System.out.println();
      
      visited = new boolean[n+1];
      bfs(r);
      bw.flush();
      
      bw.close();
      br.close();
  }
  
  static void bfs(int start) throws IOException{
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    visited[start] = true;
    bw.write(start+" ");
    
    while(!q.isEmpty()){
      int node = q.poll();
      
      for(int next : graph.get(node)){
        if(visited[next]) continue;
        visited[next] = true;
        q.add(next);
        bw.write(next+" ");
      }
    }
  }
  
  static void dfs(int node) throws IOException{
    visited[node] = true;
    bw.write(node + " ");
    for(int next : graph.get(node)){
      if(!visited[next]) dfs(next);
    }
  }
}