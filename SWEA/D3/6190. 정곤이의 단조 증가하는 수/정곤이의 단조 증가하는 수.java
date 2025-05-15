import java.util.*;
import java.io.*;

public class Solution {
    static int[] num;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
        
        int ans = -1;
        for(int i=0; i<n-1; i++){
          for(int j=i+1; j<n; j++){
            int tmp = num[i]*num[j];
            String s = Integer.toString(tmp);
            if(checkIncreasing(s)) ans = Math.max(ans, tmp); 
          }
        }
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static boolean checkIncreasing(String sNum){
    for(int i=1; i<sNum.length(); i++){
      int b = sNum.charAt(i-1)-'0';
      int a = sNum.charAt(i)-'0';
      if(b>a) return false;
    }
    return true;
  }
}