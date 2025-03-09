import java.util.*;
import java.io.*;

class Main {
    final static int MAX_COLOR = 3;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[][] cost = new int[n][MAX_COLOR];
        int[][] dp = new int[n][MAX_COLOR];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<MAX_COLOR; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }
        
        int ans = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(ans);
    }
}