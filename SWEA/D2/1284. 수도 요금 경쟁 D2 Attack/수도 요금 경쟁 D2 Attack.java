import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        int payA = w*p;
        int payB = 0;
        if(w <= r) payB = q;
        else {
          payB = q + s*(w-r);
        }
        
        int ans = Math.min(payB, payA);
      
        System.out.println("#"+t+" "+ans);
      }
  }
}