import java.util.*;
import java.io.*;

public class Main {
  static int k;
  static boolean[] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      visited = new boolean[100001];
      
      int ans = bfs(n);
      System.out.println(ans);
  }
  
  static int bfs(int start){
    Queue<int[]>q = new LinkedList<>();
    int[] move = {-1,1,2};
    q.add(new int[]{start,0});
    visited[start] = true;
    
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int position = curr[0];
      int cnt = curr[1];
      
      if(position == k) return cnt;
      for(int m : move){
        int next = position+m;
        if(m == 2) next = position*2;
        
        if(next<0 || next>100000) continue;
        if(visited[next])continue;
        visited[next] = true;
        q.add(new int[]{next,cnt+1});
      }
    }
    return 0;
  }
}