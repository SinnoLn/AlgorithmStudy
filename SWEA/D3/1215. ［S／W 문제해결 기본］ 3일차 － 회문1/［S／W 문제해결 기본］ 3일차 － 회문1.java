import java.util.*;
import java.io.*;

//8*8에서 제시된 길이를 가진 회문 개수 찾기
public class Solution {
  static char[][] cArr = new char[8][8];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<8; i++){
          cArr[i] = br.readLine().toCharArray();
        }
        
        int ans = searchPalindrome(n);
        
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int searchPalindrome(int len){
    int cnt = 0;
    for(int i=0; i<8; i++){
      for(int j=0; j<=8-len; j++){
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<len; k++){
          sb.append(cArr[i][j+k]);
        }
        if(isPalindrome(sb)) cnt++;
      }
    }
    
    for(int i=0; i<8; i++){
      for(int j=0; j<=8-len; j++){
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<len; k++){
          sb.append(cArr[j+k][i]);
        }
        if(isPalindrome(sb)) cnt++;
      }
    }
    
    return cnt;
  }
  
  static boolean isPalindrome(StringBuilder sb){
    String origin = sb.toString();
    String reversed = sb.reverse().toString();
    return origin.equals(reversed);
  }
}