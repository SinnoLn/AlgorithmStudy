import java.util.*;
import java.io.*;

public class Solution {
    static int testCase;
    static int a;
    static int b;
    static int n;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      testCase = Integer.parseInt(br.readLine());
      
      for(int t = 0; t < testCase; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        while(true){
          if(a > n || b > n) break;
          if(a > b){
            b+=a;
            ans++;
          }
          else{
            a+=b;
            ans++;
          }
        }
        System.out.println(ans);
      }
  }
}