import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      int[] endDate = {0,31,28,31,30,31,30,31,31,30,31,30,31};
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sm = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());
        int em = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        for(int i=sm; i<em; i++) ans+=endDate[i];
        ans+=ed-sd+1;
        
        System.out.println("#"+t+" "+ans);
      }
  }
}