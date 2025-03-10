import java.util.*;
import java.io.*;

class Main {
    final static int MAX_SIZE = 3;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] info = new int[n][MAX_SIZE];
        int[][] maxDP = new int[n][MAX_SIZE];
        int[][] minDP = new int[n][MAX_SIZE];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<MAX_SIZE; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDP[0][0] = info[0][0];
        maxDP[0][1] = info[0][1];
        maxDP[0][2] = info[0][2];

        minDP[0][0] = info[0][0];
        minDP[0][1] = info[0][1];
        minDP[0][2] = info[0][2];

        for(int i=1; i<n; i++){
            maxDP[i][0] = Math.max(maxDP[i-1][0],maxDP[i-1][1]) + info[i][0];
            maxDP[i][1] = Math.max(maxDP[i-1][1],Math.max(maxDP[i-1][0],maxDP[i-1][2])) + info[i][1];
            maxDP[i][2] = Math.max(maxDP[i-1][1],maxDP[i-1][2]) + info[i][2];

            minDP[i][0] = Math.min(minDP[i-1][0],minDP[i-1][1]) + info[i][0];
            minDP[i][1] = Math.min(minDP[i-1][2],Math.min(minDP[i-1][0],minDP[i-1][1])) + info[i][1];
            minDP[i][2] = Math.min(minDP[i-1][1],minDP[i-1][2]) + info[i][2];
        }
        int maxAns = Math.max(maxDP[n-1][0], Math.max(maxDP[n-1][1], maxDP[n-1][2]));
        int minAns = Math.min(minDP[n-1][0], Math.min(minDP[n-1][1], minDP[n-1][2]));

        System.out.println(maxAns +" "+ minAns);
    }
}