import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      List<Integer> list = new ArrayList<>();
      Set<Integer> set = new HashSet<>();
      
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(st.nextToken());
        if(set.contains(num)) continue;
        else {
          set.add(num);
          list.add(num);
        }
      }
      
      Collections.sort(list);
      StringBuilder sb = new StringBuilder();
      for(int i : list){
        sb.append(i).append(" ");
      }
      System.out.println(sb.toString());
    }
}