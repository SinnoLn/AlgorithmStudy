import java.util.*;
import java.io.*;

class Main {
    static class Memo {
        int day, page;
        public Memo(int day, int page) {
            this.day = day;
            this.page = page;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[N + 1];
        Memo[] memo = new Memo[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken()); 
            memo[i] = new Memo(d, p);
        }

        for (int i = 0; i < M; i++) {
            int day = memo[i].day;
            int page = memo[i].page;
            for (int j = N; j >= day; j--) {
                dp[j] = Math.max(dp[j], dp[j - day] + page);
            }
        }

        System.out.println(dp[N]);
    }
}
