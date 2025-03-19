import java.util.*;
import java.io.*;

class Main {
    public static int a;
    public static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        k = sc.nextInt();
        System.out.println(BFS());
        sc.close();
    }

    public static int BFS() {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(new int[]{a, 0});
        visited.add(a);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];

            if (num == k) return cnt;
            if (num * 2 <= k && !visited.contains(num * 2)) {
                q.offer(new int[]{num * 2, cnt + 1});
                visited.add(num * 2);
            }

            if (num + 1 <= k && !visited.contains(num + 1)) {
                q.offer(new int[]{num + 1, cnt + 1});
                visited.add(num + 1);
            }
        }
        return -1;
    }
}
