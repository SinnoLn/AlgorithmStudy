import java.util.*;
import java.io.*;

//총 간선은 N 100개
//인접행렬 100*100 10000개 
//10000번을 100번 돌리기 bfs O(n)*10000
//O(1000000)
public class Main {
    static int n;
    static int info[][];
    static int result[][];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      n = Integer.parseInt(br.readLine());
      
      info = new int[n][n];
      result = new int[n][n];

      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
          info[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      for(int i=0; i<n; i++){
        bfs(i);
      }
      
      for(int i=0; i<n; i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<n; j++){
          sb.append(result[i][j]).append(" ");
        }
        System.out.println(sb.toString());
      }
  }
  
  static void bfs(int start){
    boolean[] visited = new boolean[n];
    Deque<Integer> dq = new ArrayDeque<>();
    dq.add(start);
    
    while(!dq.isEmpty()){
      int cur = dq.poll();
      
      for(int nxt=0; nxt<n; nxt++){
        if(info[cur][nxt] == 1 && !visited[nxt]){
          visited[nxt] = true;
          result[start][nxt] = 1;
          dq.add(nxt);
        }
      }
    }
  }
}