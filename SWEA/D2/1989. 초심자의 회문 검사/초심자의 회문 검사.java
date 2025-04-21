import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      for(int test = 1; test<=t; test++){
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        
        int ans = -1;
        if(s.equals(rs)) ans = 1;
        else ans = 0;
        
        System.out.println("#"+test+" "+ans);
      }
    }
}