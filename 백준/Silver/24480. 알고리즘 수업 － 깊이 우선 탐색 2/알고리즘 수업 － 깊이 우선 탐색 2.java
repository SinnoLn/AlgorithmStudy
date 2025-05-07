import java.util.*;
import java.io.*;

public class Main {
   static boolean[] visited;
   static int[] visitOrder;
   static List<List<Integer>> graph = new ArrayList<>();
   static int order = 1;
   
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      
      visited = new boolean[n+1];
      visitOrder = new int[n+1];

      for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
      }
      
      for(int node=0; node<m; node++){
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        
        //양방향 간선
        graph.get(i).add(j);
        graph.get(j).add(i);
      }
      
      for (List<Integer> neighbors : graph) {
          Collections.sort(neighbors, Collections.reverseOrder());
      }
      
      dfs(r);
      
      for (int i = 1; i <= n; i++) {
          System.out.println(visitOrder[i]);
      }
  }
  
  static void dfs(int node){
    visited[node] = true;
    visitOrder[node] = order++;
    
    for(int next : graph.get(node)){
      if(!visited[next]) dfs(next);
    }
  }
}