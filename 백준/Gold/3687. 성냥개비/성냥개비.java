import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //만들 수 있는 가장 큰 수, 가장 작은 수
      //성냥개비를 전부 사용해야 함
      //최대 testcase 100
      //최대 성냥개비 100
      int test = Integer.parseInt(br.readLine());
      for(int t = 0; t<test; t++){
        int caseNum = Integer.parseInt(br.readLine());
        //2개 -> 1
        //3개 -> 7
        //4개 -> 4
        //5개 -> 2,(3),5 (2+3)
        //6개 -> 6,(9),0
        //7개 -> 8
        
        String minCnt = solveMin(caseNum);
        String maxCnt = solveMax(caseNum);
        
        System.out.println(minCnt + " " + maxCnt);
      }
    }
    
    //그리디?
    //DP
    //가장 작은 수
    static String solveMin(int num){
      // int[] nums = {-1,-1,1,7,4,2,6,8};
      // if(num < 8){
      //   sb.append(nums[num]);
      //   return sb.toString();
      // }
      
      // int eightCnt = num/7;
      // num%=7;
      
      // if(num == 1){
      //   sb.append(10);
      //   for(int i=0; i<eightCnt-1; i++) sb.append(8);
      // }
      // else{
      //   sb.append(nums[num]);
      //   for(int i=0; i<eightCnt; i++) sb.append(8);
      // }
      
      long[] dp = new long[101];
      Arrays.fill(dp, Long.MAX_VALUE);
      
      dp[2] = 1;
      dp[3] = 7;
      dp[4] = 4;
      dp[5] = 2;
      dp[6] = 6;
      dp[7] = 8;
      
      int[] nums = {-1,-1,1,7,4,2,0,8};
      
      for(int i=8; i<= 100; i++){
        for(int j=2; j<=7; j++){
          if(dp[i-j] != Long.MAX_VALUE){
            String tmp = dp[i-j] + "" + nums[j];
            dp[i] = Math.min(dp[i], Long.parseLong(tmp));
          }
        }
      }
      return String.valueOf(dp[num]);
    }
    
    //그리디?
    //가장 큰 수 
    static String solveMax(int num){
      StringBuilder sb = new StringBuilder();
      
      if(num%2 == 1){
        sb.append(7);
        num-=3;
      }
      
      int cnt = num/2;
      for(int i=0; i<cnt; i++) sb.append(1);
      
      return sb.toString();
    }
}