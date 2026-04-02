import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      if(n == k){
        System.out.println(0);
        System.out.println(n);
        return;
      }
      
      bfs();
    }
    
    static void bfs(){
      Deque<int[]> dq = new ArrayDeque<>();
      boolean[] visited = new boolean[100001];
      int[] parents = new int[100001];
      
      int dx[] = {2,1,-1};
      
      dq.add(new int[]{n,0});
      visited[n] = true;
      
      while(!dq.isEmpty()){
        int[] curr = dq.poll();
        int pos = curr[0];
        int cnt = curr[1];

        if(pos == k){
          System.out.println(cnt);
          Deque<Integer> list = new ArrayDeque<>();
          list.addFirst(k);
          int next = parents[k];
          
          while(true){
            list.addFirst(next);
            if(next == n){
              break;
            }
            next = parents[next];
          }
          
          StringBuilder sb = new StringBuilder();
          while(!list.isEmpty()){
            int last = list.poll();
            sb.append(last).append(' ');
          }
          
          System.out.println(sb.toString());
          return;
        }
        
        for(int dir = 0; dir<3; dir++){
          int nx = 0;
          if(dir == 0){
            nx = dx[dir]*pos;
          }
          else nx = dx[dir] + pos;
          
          if(nx<0 || nx>100000) continue;
          if(visited[nx]) continue;
          
          visited[nx] = true;
          parents[nx] = pos;
          dq.add(new int[]{nx,cnt+1});
        }
      }
    }
}