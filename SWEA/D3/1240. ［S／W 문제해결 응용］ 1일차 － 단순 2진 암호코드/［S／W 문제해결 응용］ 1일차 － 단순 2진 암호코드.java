import java.util.*;
import java.io.*;

public class Solution {
    static List<String> encoded = Arrays.asList(
    "0001101", "0011001", "0010011", "0111101", "0100011",
    "0110001", "0101111", "0111011", "0110111", "0001011"
    );
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      String cipher = "";
      for(int i=0; i<n; i++){
        String s = br.readLine();
        if(!s.contains("1")) continue;
        for(int j=m-1; j>=0; j--){
          if(s.charAt(j) == '1'){
            cipher = s.substring(j-55, j+1);
            break;
          }
        }
      }
      
      //인덱스기준 짝수자리의 합*3
      //짝수자리의 합
      int oddSum = 0;
      int evenSum = 0;
      int ans = 0;
      int[] numList = new int[8];
      for(int i=0; i<56; i+=7){
        String tmp = cipher.substring(i,i+7);
        int num = encoded.indexOf(tmp);
        numList[i/7] = num;
        
        if(i%2==0) oddSum+=num;
        else evenSum+=num;
      }
      if((oddSum*3 + evenSum)%10 == 0) ans = evenSum + oddSum;
      else ans = 0;
      
      System.out.println("#"+t+" "+ans);
      }
  }
}