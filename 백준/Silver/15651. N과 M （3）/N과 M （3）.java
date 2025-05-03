import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    List<Integer> list = new ArrayList<>();
    backtrack(0, list);
    
    bw.flush();
    bw.close();
    br.close();
  }
  
  static void backtrack(int depth, List<Integer> list) throws IOException{
    if(list.size() == m){
      StringBuilder sb = new StringBuilder();
      for(int i : list) sb.append(i).append(" ");
      bw.write(sb.toString() + "\n");
      return;
    }
    
    for(int i=1; i<=n; i++){
      list.add(i);
      backtrack(depth+1, list);
      list.remove(list.size()-1);
    }
  }
}