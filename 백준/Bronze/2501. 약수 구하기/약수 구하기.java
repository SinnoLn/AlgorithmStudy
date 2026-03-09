import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      int m = (int)Math.sqrt(n);
      List<Integer> list = new ArrayList<>();
      
      for(int i=1; i<=m; i++){
        if(n%i == 0){
          list.add(i);
          if(i*i != n) list.add(n/i);
        }
      }
      
      Collections.sort(list);
      
      if(list.size()<k) System.out.println(0);
      else System.out.println(list.get(k-1));
    }
}