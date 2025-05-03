import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      String[] vowel = {"a","e","i","o","u"};
      
      for(int t = 1; t<=test; t++){
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        
        for(String v : vowel){
          while(sb.indexOf(v) != -1) {
            int p = sb.indexOf(v);
            sb.delete(p,p+1);
          }
        }
        
        System.out.println("#"+t+" "+sb.toString());
      }
  }
}