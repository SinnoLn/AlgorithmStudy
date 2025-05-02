import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        String original = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<original.length(); i++){
          sb.append(original.charAt(i));
          
          int len = original.length()/sb.length();
          String base = original.substring(0,sb.length()*len);
          StringBuilder ss = new StringBuilder(sb);
          
          while(base.length() != ss.length()) ss.append(sb);
          if(base.equals(ss.toString())) break;
        }
        System.out.println("#"+t+" "+sb.length());
      }
  }
}