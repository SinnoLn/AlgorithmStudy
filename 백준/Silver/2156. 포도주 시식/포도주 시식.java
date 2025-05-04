import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] wine = new int[n];
      for(int i=0; i<n; i++) wine[i] = Integer.parseInt(br.readLine());
      
      int[] dp = new int[n];
      
      if(n==1){
        System.out.println(wine[0]);
        return;
      }
      if(n==2){
        System.out.println(wine[0] + wine[1]);
        return;
      } 
      if(n==3){
        System.out.println(Math.max(Math.max(wine[0]+wine[1], wine[1]+wine[2]),wine[0]+wine[2]));
        return;
      } 
      
      dp[0] = wine[0];//첫번째 와인
      dp[1] = wine[0] + wine[1]; //첫번째, 두번째 와인 다마심
      dp[2] = Math.max(Math.max(wine[0]+wine[1], wine[1]+wine[2]),wine[0]+wine[2]);
      
      //연속 세잔 불가
      for(int i=3; i<n; i++){
        dp[i] = Math.max(Math.max(dp[i-2] + wine[i], dp[i-3]+wine[i-1]+wine[i]),dp[i-1]);
      }
      
      System.out.println(dp[n-1]);
    }
}