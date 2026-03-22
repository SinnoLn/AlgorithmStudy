import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static boolean[][] visited;
    static int[][] map;
    static int[] pos;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][k];
        visited = new boolean[n][k];
        pos = new int[2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < k; j++) {
                char c = input.charAt(j);

                if (c == 'O') {
                    map[i][j] = 0;
                } else if (c == 'X') {
                    map[i][j] = 1;
                } else if (c == 'I') {
                    pos[0] = i;
                    pos[1] = j;
                    map[i][j] = 0;
                } else if (c == 'P') {
                    map[i][j] = 2;
                }
            }
        }

        int ans = bfs();
        if (ans == 0) {
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
    }

    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        int count = 0;

        dq.add(new int[]{pos[0], pos[1]});
        visited[pos[0]][pos[1]] = true;

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int y = curr[0];
            int x = curr[1];

            if (map[y][x] == 2) {
                count++;
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || nx < 0 || ny >= n || nx >= k) continue;
                if (map[ny][nx] == 1 || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                dq.add(new int[]{ny, nx});
            }
        }

        return count;
    }
}