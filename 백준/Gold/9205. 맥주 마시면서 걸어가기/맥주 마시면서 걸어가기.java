import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0; i<n+2; i++) graph.add(new ArrayList<>());
        
        int[][] pos = new int[n+2][2];
      
        for(int i=0; i<n+2; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          pos[i][0] = x;
          pos[i][1] = y;
        }
        
        ///// 로직 시작 //////
        //맥주 한박스 맥주 20개
        //50m에 한병 (맥주를 마신 후 50m)
        //두 좌표 사이의 거리는 맨해튼 거리
        
        for(int i=0; i<n+2; i++){
          for(int j=i+1; j<n+2; j++){
            int dist = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
            if(dist<=1000){
              graph.get(i).add(j);
              graph.get(j).add(i);
            }
          }
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n+2];
        
        dq.add(0);
        visited[0] = true;
        boolean can = false;
        while(!dq.isEmpty()){
          int cur = dq.poll();
          if(cur == n+1){
            can = true;
            break;
          }
          
          for(Integer next : graph.get(cur)){
            if(visited[next]) continue;
            visited[next] = true;
            dq.add(next);
          }
        }
        
        if(can) System.out.println("happy");
        else System.out.println("sad");
      }
  }
}