import java.util.*;
import java.io.*;

public class Solution {
    static char[][] puzzle;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        puzzle = new char[8][8];
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<8; i++){
          puzzle[i] = br.readLine().toCharArray();
        }
        
        int ans = countPalindrome(n);
        System.out.println("#"+t+" "+ans);
      }
  }
  static int countPalindrome(int len){
    int count = 0;
    for(int i=0; i<8; i++){
      for(int j=0; j<8-len+1; j++){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int x=j; x<j+len; x++){
          sb1.append(puzzle[i][x]);
          sb2.append(puzzle[x][i]);
        }
        
        if(isPalindrome(sb1)) count++;
        if(isPalindrome(sb2)) count++;
      }
    }
    return count;
  }
  static boolean isPalindrome(StringBuilder sb){
    int l = 0;
    int r = sb.length()-1;
    
    while(l<r){
      if(sb.charAt(l++) != sb.charAt(r--)) return false;
    }
    return true;
  }
}