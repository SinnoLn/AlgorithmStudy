import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Set<Integer> set = new HashSet<>();
      
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        int num  = Integer.parseInt(st.nextToken());
        set.add(num);
      }
      
      int m = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<m; i++){
        int num = Integer.parseInt(st.nextToken());
        if(set.contains(num)) sb.append(1).append(" ");
        else sb.append(0).append(" ");
      }
      
      System.out.println(sb.toString());
  }
}