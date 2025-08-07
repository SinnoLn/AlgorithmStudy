import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int shells = Math.min(n, m) / 2;

        for (int i = 0; i < shells; i++) {
            List<Integer> shellList = new ArrayList<>();
            
            // 왼쪽 -> 오른쪽
            for (int j = i; j < m - 1 - i; j++) {
                shellList.add(arr[i][j]);
            }
            // 위 -> 아래
            for (int j = i; j < n - 1 - i; j++) {
                shellList.add(arr[j][m - 1 - i]);
            }
            // 오른쪽 -> 왼쪽
            for (int j = m - 1 - i; j > i; j--) {
                shellList.add(arr[n - 1 - i][j]);
            }
            // 아래 -> 위
            for (int j = n - 1 - i; j > i; j--) {
                shellList.add(arr[j][i]);
            }

            int rotations = r % shellList.size();
            Collections.rotate(shellList, -rotations);

            int idx = 0;
            
            for (int j = i; j < m - 1 - i; j++) {
                arr[i][j] = shellList.get(idx++);
            }
            for (int j = i; j < n - 1 - i; j++) {
                arr[j][m - 1 - i] = shellList.get(idx++);
            }
            for (int j = m - 1 - i; j > i; j--) {
                arr[n - 1 - i][j] = shellList.get(idx++);
            }
            for (int j = n - 1 - i; j > i; j--) {
                arr[j][i] = shellList.get(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}