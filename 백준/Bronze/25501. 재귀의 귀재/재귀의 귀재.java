 import java.util.*;
import java.io.*;

public class Main {
    static int n, cnt;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      
      for(int i=0; i<n; i++){
        String input = br.readLine();
        int ans = isPalindrome(input);
        System.out.println(ans + " " + cnt);
      }
  }
  
  static int recursion(String s, int l, int r){
    cnt++;
    if(l>=r) return 1;
    else if(s.charAt(l) != s.charAt(r)) return 0;
    else return recursion(s, l+1, r-1);
  }
  
  static int isPalindrome(String s){
    cnt = 0;
    return recursion(s,0,s.length()-1);
  }
}