import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        for(int i=-n; i<=n; i++){
          for(int j=-n; j<=n; j++){
            if(i*i+j*j <= n*n) cnt++;
          }
        }
        System.out.println("#"+t+" "+cnt);
      }
  }
}