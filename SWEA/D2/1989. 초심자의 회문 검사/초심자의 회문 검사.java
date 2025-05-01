import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        String s = br.readLine();
        System.out.println("#"+t+" "+isPalindrome(s));
      }
  }
  
  static int isPalindrome(String s){
    int l = 0;
    int r = s.length()-1;

    while(l<r){
      if(s.charAt(l++) != s.charAt(r--)) return 0;
    }
    return 1;
  }
}