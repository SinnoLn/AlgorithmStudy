import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int test = Integer.parseInt(br.readLine());
        for(int t=1; t<=test; t++){
          int n = Integer.parseInt(br.readLine());
          int[] arr = new int[n];
          
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
          
          int ans = -1;
          for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
              int tmp = arr[i]*arr[j];
              if(isIncrease(tmp)) ans = Math.max(ans, tmp);
            }
          }
          System.out.println("#"+t+" "+ans);
        }
  }
  
  static boolean isIncrease(int num){
    String sNum = Integer.toString(num);
    for(int i=1; i<sNum.length(); i++){
      if(sNum.charAt(i-1) > sNum.charAt(i)) return false;
    }
    return true;
  }
}