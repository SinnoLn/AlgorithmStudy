import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      Set<String> set = new HashSet<>();
      
      for(int i=0; i<n; i++){
        String s = br.readLine();
        set.add(s);
      }
      
      int cnt = 0;
      for(int i=0; i<m; i++){
        String check = br.readLine();
        if(set.contains(check)) cnt++;
      }
      
      System.out.println(cnt);
  }
}