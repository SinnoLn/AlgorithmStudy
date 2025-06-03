import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int w, h;
    static boolean[] keys;
    static Map<Character, List<int[]>> doorMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            keys = new boolean[26];
            doorMap = new HashMap<>();

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }

            String s = br.readLine();
            if (!s.equals("0")) {
                for (char c : s.toCharArray()) {
                    keys[c - 'a'] = true;
                }
            }

            int result = bfs();

            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[h][w];
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            if (map[i][0] != '*') q.add(new int[]{i, 0});
            if (map[i][w - 1] != '*') q.add(new int[]{i, w - 1});
        }
        for (int i = 0; i < w; i++) {
            if (map[0][i] != '*') q.add(new int[]{0, i});
            if (map[h - 1][i] != '*') q.add(new int[]{h - 1, i});
        }

        for (int[] start : q) {
            visited[start[0]][start[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            char c = map[y][x];

            if (c == '$') {
                cnt++;
                map[y][x] = '.';
            }

            // 열쇠 획득
            if (c >= 'a' && c <= 'z') {
                int idx = c - 'a';
                if (!keys[idx]) {
                    keys[idx] = true;
                    char door = (char) (c - 32); // to upper
                    if (doorMap.containsKey(door)) {
                        for (int[] pos : doorMap.get(door)) {
                            q.add(pos);
                            visited[pos[0]][pos[1]] = true;
                        }
                    }
                }
            }

            // 문일 경우
            if (c >= 'A' && c <= 'Z') {
                int idx = c - 'A';
                if (!keys[idx]) {
                    doorMap.computeIfAbsent(c, k -> new ArrayList<>()).add(new int[]{y, x});
                    continue;
                }
            }

            // 이동
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                if (visited[ny][nx] || map[ny][nx] == '*') continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }

        return cnt;
    }
}
