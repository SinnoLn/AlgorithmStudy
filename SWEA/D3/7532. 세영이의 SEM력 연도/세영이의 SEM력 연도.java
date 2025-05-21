import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int ts = 1;
        int te = 1;
        int tm = 1;
        int year = 1;
        
        while(true){
          if(ts==s && te==e && tm==m) break;
          ts = (ts+1)%365;
          te = (te+1)%24;
          tm = (tm+1)%29;
          
          if(ts == 0) ts = 365;
          if(te == 0) te = 24;
          if(tm == 0) tm = 29;

          year++;
        }
        
        System.out.println("#"+t+" "+year);
      }
  }
}