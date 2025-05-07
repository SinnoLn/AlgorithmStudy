import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] visitedOrder;
    static int index = 1;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      
      visited = new boolean[n+1];
      visitedOrder = new int[n+1];
      
      for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
    
      for(int node=0; node<m; node++){
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        
        graph.get(i).add(j);
        graph.get(j).add(i);
      }
      
      //오름차 순 정렬
      for(List<Integer> neighbors : graph){
        Collections.sort(neighbors,Collections.reverseOrder());
      }
      
      bfs(r);
      
      for (int i = 1; i <= n; i++) bw.write(visitedOrder[i]+"\n");
      
      bw.flush();
      bw.close();
      br.close();
  }
  
  static void bfs(int start){
    Queue<Integer> q = new LinkedList<>();
    
    q.add(start);
    visited[start] = true;
    visitedOrder[start] = index++;
    
    while(!q.isEmpty()){
      int node = q.poll();
      for(int next : graph.get(node)){
        if(visited[next]) continue;
        visited[next] = true;
        q.add(next);
        visitedOrder[next] = index++;
      }
    }
  }
}