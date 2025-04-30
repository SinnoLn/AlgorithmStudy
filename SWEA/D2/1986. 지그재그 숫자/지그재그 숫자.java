import java.util.*;
import java.io.*;

//1부터 N까지의 숫자에서 홀수는 더하고 
//짝수는 뺐을 때 최종 누적된 값을 구해보자.
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=1; i<=n; i++){
          sum+=(i%2 == 0)?-i:i;
        }
        System.out.println("#"+t+" "+sum);
      }
  }
}