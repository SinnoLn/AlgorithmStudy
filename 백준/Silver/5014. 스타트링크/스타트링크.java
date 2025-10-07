import java.util.*;
import java.io.*;

public class Main {
  static int F,S,G,U,D;
  static int dx[];
  static boolean visited[];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      //총 f층, 지금 s층, g층으로 이동 예정
      //up버튼이나 down버튼
      
      F = Integer.parseInt(st.nextToken());
      S = Integer.parseInt(st.nextToken());
      G = Integer.parseInt(st.nextToken());
      U = Integer.parseInt(st.nextToken());
      D = Integer.parseInt(st.nextToken());
      
      visited = new boolean[F+1];
      dx = new int[]{-D, U};
      int ans= bfs();
      if(ans == -1) System.out.println("use the stairs");
      else System.out.println(ans);
  }
  
  static int bfs(){
    Deque<int[]> dq = new ArrayDeque<>();
    dq.add(new int[]{S,0});
    
    while(!dq.isEmpty()){
      int curr[] = dq.poll();
      int pos = curr[0];
      int cnt = curr[1];
      
      if(pos == G) return cnt;
      for(int dir=0; dir<2; dir++){
        int nx = pos + dx[dir];
        if(nx<1 || nx>F) continue;
        if(visited[nx]) continue;
        dq.add(new int[]{nx,cnt+1});
        visited[nx] = true;
      }
    }
    return -1;
  }
}