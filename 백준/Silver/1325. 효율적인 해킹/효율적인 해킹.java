import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();

    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { this.in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return val * sign;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = fs.nextInt();
        m = fs.nextInt();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            graph.get(b).add(a);
        }

        int[] reach = new int[n + 1];
        int maxCnt = 0;

        boolean[] visited = new boolean[n + 1];
        for (int s = 1; s <= n; s++) {
            Arrays.fill(visited, false);
            reach[s] = bfsCount(s, visited);
            if (reach[s] > maxCnt) maxCnt = reach[s];
        }

        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) if (reach[i] == maxCnt) out.append(i).append(' ');
        if (out.length() > 0) out.setLength(out.length() - 1);
        bw.write(out.toString());
        bw.write('\n');
        bw.flush();
    }

    static int bfsCount(int start, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.addLast(start);
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            List<Integer> adj = graph.get(cur);
            for (int i = 0, sz = adj.size(); i < sz; i++) {
                int next = adj.get(i);
                if (visited[next]) continue;
                visited[next] = true;
                q.addLast(next);
                cnt++;
            }
        }
        return cnt;
    }
}
