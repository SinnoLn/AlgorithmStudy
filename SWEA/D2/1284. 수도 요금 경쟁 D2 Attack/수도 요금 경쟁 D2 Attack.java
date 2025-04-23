import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      for(int test=1; test<=t; test++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        int aFee = 0;
        int bFee = 0;
        
        aFee = p*w;
        if(w<=r) bFee = q;
        else bFee = q + (w-r)*s;

        int ans = Math.min(aFee, bFee);
        System.out.println("#"+test+" "+ans);
      }
  }
}