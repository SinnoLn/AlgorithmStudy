import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     for(int t=1; t<=10; t++){
       int test = Integer.parseInt(br.readLine());
       String p = br.readLine();
       String s = br.readLine();
       
       int cnt = 0;
       while(s.indexOf(p) != -1){
         int n = s.indexOf(p);
         cnt++;
         s = s.substring(0,n) + s.substring(n+p.length());
       }
       System.out.println("#"+test+" "+cnt);
     }
  }
}