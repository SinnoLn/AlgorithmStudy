import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //1부터 9까지만 계산 가능
      int test = Integer.parseInt(br.readLine());
      for(int t = 1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        if(a>9||b>9) ans = -1;
        else ans = a*b;
        
        System.out.println("#"+t+" "+ans);
      }
  }
}