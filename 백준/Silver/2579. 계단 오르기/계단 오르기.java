import java.util.*;
import java.io.*;

//다음 계단으로 가거나, 다다음 계단으로 가거나
//연속된 세개의 계단 모두 밟으면 안됨
//마지막 도착 계단 반드시 밟기
//시작은 계단이 아님
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] stair = new int[n];
      
      for(int i=0; i<n; i++) stair[i] = Integer.parseInt(br.readLine());
    
      if(n == 1) System.out.println(stair[0]);
      else if(n == 2) System.out.println(stair[0]+stair[1]);
      else {
        int[] dp = new int[n];
        dp[0] = stair[0];
        dp[1] = stair[0] + stair[1];
        dp[2] = Math.max(stair[0]+stair[2], stair[1]+stair[2]);
        
        //총 점수의 최댓값
        for(int i=3; i<n; i++){
          dp[i] = Math.max(dp[i-3] + stair[i-1]+ stair[i], dp[i-2]+stair[i]); 
        }
        System.out.println(dp[n-1]);
      }
  }
}