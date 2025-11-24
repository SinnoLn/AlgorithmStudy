import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int bundle = Integer.MAX_VALUE;
      int one = Integer.MAX_VALUE;
      
      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        bundle = Math.min(bundle,Integer.parseInt(st.nextToken()));
        one = Math.min(one,Integer.parseInt(st.nextToken()));
        
      }
      
      int ans = Integer.MAX_VALUE;
      int cnt = n/6;
      if(n%6 != 0) cnt++;
    
      ans = Math.min(bundle*cnt,Math.min(one*n,bundle*(n/6)+one*(n%6)));
      System.out.println(ans);
  }
}