import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[] adj;
    static long[] memo;
    static final long UNVIS = -1L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            adj = new int[N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                if (a == b) continue;
                adj[a] |= (1 << b);
                adj[b] |= (1 << a);
            }

            int all = (N == 32) ? -1 : ((1 << N) - 1);
            memo = new long[1 << N];
            Arrays.fill(memo, UNVIS);

            long ans = dfs(all);
            out.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.print(out);
    }
    
    static long dfs(int avail) {
        if (avail == 0) return 1;
        if (memo[avail] != UNVIS) return memo[avail];

        // 가장 낮은 비트 선택
        int lsbMask = avail & -avail;
        int v = Integer.numberOfTrailingZeros(lsbMask);

        // 1) v를 선택하지 않는 경우: v만 제거
        long notPick = dfs(avail & ~lsbMask);

        // 2) v를 선택하는 경우: v와 v의 이웃들을 모두 제거
        int remove = lsbMask | adj[v];
        long pick = dfs(avail & ~remove);

        return memo[avail] = notPick + pick;
    }
}
