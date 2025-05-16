import java.util.*;
import java.io.*;

public class Solution {
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int r, c;
    static List<Character> dirChar = Arrays.asList('<','>','^','v');

    static class State {
        int y, x, dir, memory;
        State(int y, int x, int dir, int memory) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.memory = memory;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new char[r][c];
            visited = new boolean[r][c][4][16];

            for (int i = 0; i < r; i++) {
                map[i] = br.readLine().toCharArray();
            }

            if (bfs()) System.out.println("#" + t + " YES");
            else System.out.println("#" + t + " NO");
        }
    }

    static boolean bfs() {
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 1, 0));

        while (!q.isEmpty()) {
            State s = q.poll();
            int y = s.y, x = s.x, dir = s.dir, memory = s.memory;

            if (visited[y][x][dir][memory]) continue;
            visited[y][x][dir][memory] = true;

            char op = map[y][x];

            if(op == '@') return true;
            else if(dirChar.indexOf(op) != -1) dir = dirChar.indexOf(op);
            else if(op == '_') dir = (memory == 0) ? 1 : 0;
            else if(op == '|') dir = (memory == 0) ? 3 : 2;
            else if(op >= '0' && op <= '9') memory = op - '0';
            else if(op == '+') memory = (memory == 15) ? 0 : memory + 1;
            else if(op == '-') memory = (memory == 0) ? 15 : memory - 1;

            if (op == '?') {
                for (int d = 0; d < 4; d++) {
                    int ny = (y + dy[d] + r) % r;
                    int nx = (x + dx[d] + c) % c;
                    q.add(new State(ny, nx, d, memory));
                }
            } else {
                int ny = (y + dy[dir] + r) % r;
                int nx = (x + dx[dir] + c) % c;
                q.add(new State(ny, nx, dir, memory));
            }
        }
        return false;
    }
}
