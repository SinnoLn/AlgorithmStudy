import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        //그냥도, 루트도 펠린드롬
        for(int i=a; i<=b; i++){
          String s = Integer.toString(i);
          if(!isPalindrome(s)) continue;
          
          double tmp = Math.sqrt(i);
          if(tmp != (int)tmp) continue; //정확한 제곱수
          String ss = Integer.toString((int)tmp);
          if(!isPalindrome(ss)) continue;
          
          cnt++;
        }
        System.out.println("#"+t+" "+cnt);
      }
  }
  
  static boolean isPalindrome(String s){
    int l = 0;
    int r = s.length()-1;
    
    while(l<r){
      if(s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
  }
}