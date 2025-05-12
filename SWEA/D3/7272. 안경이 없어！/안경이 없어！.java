import java.util.*;
import java.io.*;

public class Solution {
    static String[] hole = {"CEFGHIJKLMNSTUVWXYZ","ADOPQR","B"};
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test ; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        
        String ans = "DIFF";
        if(s1.length() == s2.length()){
          s1 = changeChar(s1);
          s2 = changeChar(s2);
          
          if(s1.equals(s2)) ans = "SAME";
        }
        System.out.println("#"+t+" "+ans);
      }
  }
  static String changeChar(String s){
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      for(int j=0; j<hole.length; j++){
        if(!hole[j].contains(String.valueOf(c))) continue;
        sb.append(j);
        break;
      }
    }
    return sb.toString();
  }
}