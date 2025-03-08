import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] land = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[n][m];
        dp[0][0] = land[0][0];
        for(int i=1; i<n; i++) dp[i][0] = land[i][0] + dp[i-1][0];
        for(int j=1; j<m; j++) dp[0][j] = land[0][j] + dp[0][j-1];
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                dp[i][j] = land[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        System.out.println(dp[n-1][m-1]);
    }
}