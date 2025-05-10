import java.util.*;
import java.io.*;

public class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n+1];
        graph.clear();
        max = 0;
        for(int i=0; i<=n; i++){
          graph.add(new ArrayList<>());
        }
        
        for(int node=0; node<m; node++){
          st = new StringTokenizer(br.readLine());
          int i = Integer.parseInt(st.nextToken());
          int j = Integer.parseInt(st.nextToken());
          graph.get(i).add(j);
          graph.get(j).add(i);
        }
        
        for(int i=1; i<=n; i++){
          if(visited[i]) continue;
          dfs(i, 1);
        }
        System.out.println("#"+t+" "+max);
      }
  }
  
  static void dfs(int node, int count){
    visited[node] = true;
    max = Math.max(max, count);
    
    for(int next : graph.get(node)){
      if(!visited[next]) dfs(next, count+1);
    }
    visited[node] = false;
  }
}