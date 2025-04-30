import java.util.*;
import java.io.*;

//가장 긴 회문이면 Dp로 풀 수 있을것 같은데 
//완전탐색과 dp 충분히 가능
public class Solution {
    static char[][] cArr;
    static int ans;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=0; t<10; t++){
        int test = Integer.parseInt(br.readLine());
        cArr = new char[100][100];
        ans = 0;
        
        for(int i=0; i<100; i++){
          cArr[i] = br.readLine().toCharArray();
        }
        
        int ans = searchPalindrome();
        System.out.println("#"+test+" "+ans);
      }
  }
  
  static int searchPalindrome(){
    int len = 100;
   while(len>0){
    for(int i=0; i<100; i++){
      for(int j=0; j<100; j++){
        if(j+len>100)continue;
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int k=0; k<len; k++){
          sb1.append(cArr[i][j+k]);
          sb2.append(cArr[j+k][i]);
        }
        if(isPalindrome(sb1)){
          return len;
        }
        if(isPalindrome(sb2)){
          return len;
        }
      }
    }
    len--;
   }
    return 1;
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