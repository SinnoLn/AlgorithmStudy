import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int ans = cntSuccessiveNum(n);
        
        System.out.println("#"+t+" "+ans);
      }
  }
  static int cntSuccessiveNum(int num){
    int count = 0;
    for (int k = 1; k*(k-1)/2 < num; k++) {
      int numerator = num - k*(k-1)/2;
      if (numerator % k == 0) {
          count++;
      }
    }
    return count;
  }
}