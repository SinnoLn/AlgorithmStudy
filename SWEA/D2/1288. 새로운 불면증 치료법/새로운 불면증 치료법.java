import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[10];
        
        int ans = whichNum(n, num);
        System.out.println("#"+t+" "+ans);
      }
  }
  static int whichNum(int n, int[] num){
    int original = n;
    int cnt = 0;
    int idx = 1;
    while(true){
          String s = Integer.toString(n);
          for(int i=0; i<s.length(); i++){
            if(num[s.charAt(i)-'0'] == 0){
              num[s.charAt(i)-'0']++;
              cnt++;
            }
            if(cnt == 10) return n;
          }
          idx++;
          n = original*(idx);
        }
  }
}