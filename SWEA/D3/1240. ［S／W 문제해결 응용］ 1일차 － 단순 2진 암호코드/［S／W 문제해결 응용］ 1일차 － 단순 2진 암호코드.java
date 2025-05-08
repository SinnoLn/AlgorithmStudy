import java.util.*;
import java.io.*;

//8비트로 7개 총 56
//올바른 암호코드: (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수
public class Solution {
    static int n,m;
    static String[] s;
    static String cipher;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
    
      for(int t = 1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = new String[n];
        
        for(int i=0; i<n; i++) s[i] = br.readLine();
        for(int i=n-1; i>-1; i--){
          if(s[i].contains("1")){
           int ans = isCipher(s[i]);
           System.out.println("#"+t+" "+ans);
           break; 
          }
        }
      }
  }
  
  //암호문 파싱 및 해독
  static int isCipher(String s){
    List<String> encoded = Arrays.asList("0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011");

    for(int i=(m-1); i>-1; i--){
      if(s.charAt(i) == '1') {
        cipher = s.substring(i-55,i+1);
        break;
      }
    }
    
    int oddSum = 0;
    int evenSum = 0;
    for(int i=0; i<56; i+=7){
      String ss = cipher.substring(i, i+7);
      int idx = encoded.indexOf(ss);
      
      if(i%2 == 1) evenSum+=idx;
      else oddSum+=idx;
    }
    
    if((oddSum*3+evenSum)%10 == 0) return oddSum+evenSum;
    else return 0;
  }
}