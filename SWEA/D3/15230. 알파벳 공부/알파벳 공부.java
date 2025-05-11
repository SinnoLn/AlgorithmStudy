import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      String original = "abcdefghijklmnopqrstuvwxyz";
      
      for(int t=1; t<=test; t++){
        String s= br.readLine();
       
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
          if(s.charAt(i) == original.charAt(i)) cnt++;
          else break;
        }
        System.out.println("#"+t+" "+cnt);
      }
  }
}