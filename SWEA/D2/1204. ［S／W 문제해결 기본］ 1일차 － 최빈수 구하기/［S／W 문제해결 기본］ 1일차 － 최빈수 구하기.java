import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int[] grade = new int [101];
        int num = Integer.parseInt(br.readLine());
        int maxNum = 0;
        int maxCnt = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<1000; i++){
          int n = Integer.parseInt(st.nextToken());
          grade[n]++;
          
          if(maxCnt<=grade[n]){
            if(maxCnt<grade[n]) {
              maxNum = n;
              maxCnt = grade[n];
            }
            else maxNum = n;
        }
      }
      System.out.println("#"+num+" "+maxNum);
  }
}
}