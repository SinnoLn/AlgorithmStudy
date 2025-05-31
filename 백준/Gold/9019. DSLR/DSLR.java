import java.util.*;
import java.io.*;

public class Main {
    static class State{
      int num;
      String com;
      
      public State(int num, String com){
        this.num = num;
        this.com = com;
      }
    };
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        String ans = bfs(a, b ,"");
        System.out.println(ans);
      }
  }
  
  static String bfs(int a, int b, String command){
    Queue<State> q = new LinkedList<>();
    boolean visited[] = new boolean[10000];
    q.add(new State(a, ""));
    visited[a] = true;
    
    while(!q.isEmpty()){
      State state = q.poll();
      if(state.num == b) return state.com;
      
      int cur = state.num;
      
      int D = (cur*2)%10000;
      if(!visited[D]){
        visited[D] = true;
        q.add(new State(D, state.com + "D"));
      }
      
      int S = (cur == 0) ? 9999 : cur-1;
      if(!visited[S]){
        visited[S] = true;
        q.add(new State(S, state.com + "S"));
      }
      
      int L = (cur % 1000) * 10 + (cur / 1000);
      if(!visited[L]){
        visited[L] = true;
        q.add(new State(L, state.com + "L"));
      }
      
      int R = (cur % 10) * 1000 + (cur / 10);
      if(!visited[R]){
        visited[R] = true;
        q.add(new State(R, state.com + "R"));
      }
    }
    
    return "";
  }
}