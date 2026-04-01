import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int[] tmp;
    static int n;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        tmp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);
    }

    static void backtrack(int depth) {
        if (found) return;

        if (depth == n) {
            if (check()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(tmp[i]).append(" ");
                }
                System.out.println(sb.toString().trim());
                found = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            tmp[depth] = i;
            visited[i] = true;
            backtrack(depth + 1);
            visited[i] = false;
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            int person = tmp[i];
            int count = 0;

            for (int j = 0; j < i; j++) {
                if (tmp[j] > person) count++;
            }

            if (count != arr[person]) return false;
        }
        return true;
    }
}