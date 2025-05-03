import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      List<Integer> list = new ArrayList<>();
      
      visited = new boolean[n+1];
      backtrack(0, list);
  }
  
  static void backtrack(int depth, List<Integer> list){
    if(depth == m) {
      for(int i=0; i<list.size(); i++) System.out.print(list.get(i)+" ");
      System.out.println();
    }
    
    for(int i=1; i<=n; i++){
      if(visited[i]) continue;
      visited[i] = true;
      list.add(i);
      backtrack(depth+1, list);
      visited[i] = false;
      list.remove(list.size()-1);
    }
  }
}