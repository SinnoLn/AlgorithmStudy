import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);
            g[v].add(u);
        }

        boolean[] visited = new boolean[N + 1];
        int components = 0;

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            components++;
            visited[i] = true;
            q.clear();
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : g[cur]) {
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        q.add(nxt);
                    }
                }
            }
        }

        System.out.println(components);
    }
}
