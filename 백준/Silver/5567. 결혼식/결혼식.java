import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static List<List<Integer>>graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      n = Integer.parseInt(br.readLine());
      m = Integer.parseInt(br.readLine());
      
      for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
      
      for(int i=0; i<m; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
      
      Deque<int[]> dq = new ArrayDeque<>();
      boolean[] visited = new boolean[n+1];
      
      dq.add(new int[]{1,0});
      visited[1] = true;
      
      int ans = 0;
      while(!dq.isEmpty()){
        int curr[] = dq.poll();
        int node = curr[0];
        int cnt = curr[1];
        
        if(cnt>2) continue;
        ans++;
        
        for(Integer next : graph.get(node)){
          if(visited[next]) continue;
          dq.add(new int[]{next,cnt+1});
          visited[next] = true;
        }
      }
      
      System.out.println(ans-1);
  }
}