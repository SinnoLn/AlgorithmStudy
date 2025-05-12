import java.util.*;
import java.io.*;

public class Solution {
    static char[][] puzzle;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t<=10; t++){
        int test = Integer.parseInt(br.readLine());
        puzzle = new char[100][100];
        for(int i=0; i<100; i++){
          puzzle[i] = br.readLine().toCharArray();
        }
        
        int ans = calLongestPalindrome();
        System.out.println("#"+test+" "+ans);
      }
  }
  
  static int calLongestPalindrome(){
    int len = 100;
   while(len>0){
    for(int i=0; i<100; i++){
      for(int j=0; j<100; j++){
        if(j+len>100)continue;
         
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int k=0; k<len; k++){
          sb1.append(puzzle[i][j+k]);
          sb2.append(puzzle[j+k][i]);
        }
        if(isPalindrome(sb1)) return len;
        if(isPalindrome(sb2)) return len;
      }
    }
    len--;
   }
    return 1;
  }
  
  static boolean isPalindrome(StringBuilder sb){
    int l = 0;
    int r = sb.length()-1;
    
    while(l < r){
      if(sb.charAt(l++) != sb.charAt(r--)) return false;
    }
    return true;
  }
}