import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    List<Integer> list = new ArrayList<>();
    backtrack(1, list);
  }
  
  static void backtrack(int start, List<Integer> list){
    if(list.size() == m){
      for(int i : list) System.out.print(i+" ");
      System.out.println();
      return;
    }
    
    for(int i=start; i<=n; i++){
      list.add(i);
      backtrack(i+1, list);
      list.remove(list.size()-1);
    }
  }
}