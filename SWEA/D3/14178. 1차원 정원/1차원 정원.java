import java.util.*;
import java.io.*;

//모든 꽃이 한 개 이상의 분무기에서 물을 받을 수 있도록 하기 위해 필요한 최소한의 분무기
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        double n = (double)Integer.parseInt(st.nextToken());
        double d = (double)Integer.parseInt(st.nextToken());

        //n개의 꽃 d범위 
        double ans = Math.ceil(n/(2*d+1));
        System.out.println("#"+t+" "+(int)ans);
      }
  }
}