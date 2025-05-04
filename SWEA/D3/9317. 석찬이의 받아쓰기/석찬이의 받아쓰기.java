import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int len = Integer.parseInt(br.readLine());
        
        String original = br.readLine();
        String dictation = br.readLine();
        
        int cnt = 0;
        for(int i=0; i<len; i++){
          if(original.charAt(i) == dictation.charAt(i)) cnt++;
        }
        
        System.out.println("#"+t+" "+cnt);
      }
  }
}