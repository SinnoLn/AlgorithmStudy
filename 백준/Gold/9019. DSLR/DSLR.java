import java.util.*;
import java.io.*;

public class Main {
    static class State{
      int num;
      String op;
      
      public State(int num, String op){
        this.num = num;
        this.op = op;
      }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        String ans = bfs(a,b,"");
        System.out.println(ans);
      }
    }
    
    static String bfs(int a, int b, String command){
      Deque<State> dq = new ArrayDeque<>();
      boolean[] visited = new boolean[10000];
      
      dq.add(new State(a, ""));
      visited[a] = true;
      
      while(!dq.isEmpty()){
        State state = dq.poll();
        int curr = state.num;
        String op = state.op;
        
        if(b == curr) return op;

        int d = (curr*2)%10000;
        if(!visited[d]){
          visited[d] = true;
          dq.add(new State(d, op+"D"));
        }
        
        int s = (curr == 0) ? 9999 : curr-1;
        if(!visited[s]){
          visited[s] = true;
          dq.add(new State(s, op+"S"));
        }
        
        int l = (curr%1000) * 10 + (curr/1000);
        if(!visited[l]){
          visited[l] = true;
          dq.add(new State(l, op+"L"));
        }
        
        int r = (curr%10) * 1000 + (curr/10);
        if(!visited[r]){
          visited[r] = true;
          dq.add(new State(r, op+"R"));
        }
      }
      return "";
    }
}