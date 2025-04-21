import java.util.*;
import java.io.*;

//최대 10마디 반복
//문자열의 최대 길이
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      for(int test = 1; test<=t; test++){
        String s = br.readLine();
        
        //마디열 반복
        String tmp = "";
        for(int i=1; i<=10; i++){
          tmp+=s.charAt(i-1);
          String tmpString ="";
          
          int div = s.length()/i;
          for(int j=0; j<div; j++) tmpString+=tmp;
          
          String diffString = s.substring(0,i*div);
          if(diffString.equals(tmpString)) break;
          
        }
        System.out.println("#"+test+" "+tmp.length());
      }
  }
}