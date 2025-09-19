import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            indegree[B]++;  
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int v = 1; v <= N; v++) {
            if (indegree[v] == 0) q.add(v);
        }

        StringBuilder sb = new StringBuilder();
        int out = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(' ');
            out++;

            for (int w : adj[u]) {
                if (--indegree[w] == 0) q.add(w);
            }
        }

        System.out.println(sb.toString());
    }
}