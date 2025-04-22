import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for(int test = 1; test<=t; test++){
        System.out.println("#"+test);
        int n = Integer.parseInt(br.readLine());
        String s = "";
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          char a = st.nextToken().charAt(0);
          int num = Integer.parseInt(st.nextToken());
          
          for(int j=0; j<num; j++){
            s+=a;
            if(s.length() == 10){
              System.out.println(s);
              s="";
            }
          }
        }
        if(s.length() != 10) System.out.println(s);
      }
    }
}