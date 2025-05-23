import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] coin = new int[n];
        for(int i=0; i<n; i++) coin[i] = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(br.readLine());
        
        int[] dp = new int[target+1];
        dp[0] = 1; //0원을 만드는 법은 아무것도 사용하지 않는 1가지
        for(int i=0; i<n; i++){
          for(int j=coin[i]; j<=target; j++){
            dp[j]+=dp[j-coin[i]];
          }
        }
        
        System.out.println(dp[target]);
      }
  }
}