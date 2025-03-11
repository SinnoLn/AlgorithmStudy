import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int x = 0, y = 0, dir = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean isValid = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (op.equals("MOVE")) {
                x += dx[dir] * num;
                y += dy[dir] * num;
            } else {
                if (num == 0) dir = (dir + 1) % 4; //시계방향
                else dir = (dir + 3) % 4; //반시계방향
            }

            if (x < 0 || y < 0 || x >= m || y >= m) {
                isValid = false;
                break;
            }
        }
        System.out.println(isValid ? (y + " " + x) : -1);
    }
}
