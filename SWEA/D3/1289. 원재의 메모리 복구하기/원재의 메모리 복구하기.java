import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        String s = br.readLine();
        
        int cnt = 0;
        boolean check = false;
        if(s.charAt(0) == '1') cnt++;
        for(int i=1; i<s.length(); i++){
          if(s.charAt(i) != s.charAt(i-1)){
            cnt++;
          }
        }
        System.out.println("#"+t+" "+cnt);
      }
  }
}