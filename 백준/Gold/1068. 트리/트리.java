import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>>graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int root = 0;

      for(int i=0; i<n; i++) graph.add(new ArrayList<>());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(st.nextToken());
        if(num == -1){
          root = i;
          continue;
        }
        graph.get(num).add(i);
        graph.get(i).add(num);
      }
      
      int k = Integer.parseInt(br.readLine());
      
      int cnt = 0;
      Deque<Integer> dq = new ArrayDeque<>();
      boolean[] visited = new boolean[n];
      
      dq.add(root);
      visited[root] = true;
      
      while(!dq.isEmpty()){
        int node = dq.poll();
        
        if(k==root) {
          System.out.println(0);
          return;
        }
        
        int childCnt = 0;
        //내려갈 곳이 있다면 child존재
        for(Integer next : graph.get(node)){
          if(visited[next]) continue;
          if(next == k) continue;
          
          childCnt++;
          dq.add(next);
          visited[next] = true;
        }
        if(childCnt == 0) cnt++;
      }
      System.out.println(cnt);
  }
}