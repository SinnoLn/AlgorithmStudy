import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      boolean[] check;
      int ans = 0;
      
      for(int i=0; i<n; i++){
        String s = br.readLine();
        check = new boolean[26];
        
        char memo = s.charAt(0);
        check[memo-'a'] = true;
        ans ++;
        if(s.length() == 1) continue;
        
        for(int j=1; j<s.length(); j++){
          if(memo == s.charAt(j)) continue;
          else {
            if(check[s.charAt(j)-'a']){
              ans--;
              break;
            }
            else {
              check[s.charAt(j)-'a'] = true;
              memo = s.charAt(j);
            }
          }
        }
      }
      System.out.println(ans);
  }
}