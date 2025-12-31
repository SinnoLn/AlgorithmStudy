import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String s = br.readLine();
      int[] num = new int[9];
      
      for(int i=0; i<s.length(); i++){
        int n = s.charAt(i)-'0';
        if(n == 9) n = 6;
        
        num[n]++;
      }
      
      int ans = 0;
      for(int i=0; i<9; i++){
        int p = num[i];
        if(i == 6){
         if(num[i]%2 == 0) p = num[i]/2;
         else p = num[i]/2 + 1;
        }
        ans = Math.max(ans, p);
      }
      
      System.out.println(ans);
  }
}