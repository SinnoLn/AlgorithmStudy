import java.util.*;
import java.io.*;

public class Solution {
    static final int MAX_NODE = 101;
    static Set<String> set = new HashSet<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t<=10; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int data = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());
        for(int i=0; i<MAX_NODE; i++) graph.add(new ArrayList<>());
        visited = new boolean[MAX_NODE];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<data/2; i++){
          int from = Integer.parseInt(st.nextToken());
          int too = Integer.parseInt(st.nextToken());
          
          String memo = from + "," + too;
          if(set.contains(memo)) continue;
          set.add(memo);
          
          graph.get(from).add(too);
        }
        
        int ans = bfs(startPoint);
        System.out.println("#"+t+" "+ans);
        
        set.clear();
        graph.clear();
      }
  }
  
  static int bfs(int start){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{start, 0});
    visited[start] = true;
    int maxDepth = 0;
    int maxNode = 0;
    
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int node = curr[0];
      int depth = curr[1];
      
      if(maxDepth<=depth){
        if(maxDepth == depth) maxNode = Math.max(maxNode,node);
        else {
          maxDepth = depth;
          maxNode = node;
        }
      }
      
      for(int next : graph.get(node)){
        if(visited[next]) continue;
        visited[next] = true;
        q.add(new int[]{next, depth+1});
      }
    }
    return maxNode;
  }
}