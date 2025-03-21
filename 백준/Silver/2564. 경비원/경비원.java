import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken()); // 가로
        int H = Integer.parseInt(st.nextToken()); // 세로
        int N = Integer.parseInt(br.readLine()); // 상점 수

        int totalPerimeter = 2 * (W + H);
        int[] shops = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shops[i] = convertToDistance(dir, dist, W, H);
        }

        st = new StringTokenizer(br.readLine());
        int dongDir = Integer.parseInt(st.nextToken());
        int dongDist = Integer.parseInt(st.nextToken());
        int dongPos = convertToDistance(dongDir, dongDist, W, H);

        int sum = 0;
        for (int shop : shops) {
            int diff = Math.abs(dongPos - shop);
            sum += Math.min(diff, totalPerimeter - diff);
        }

        System.out.println(sum);
    }

    public static int convertToDistance(int dir, int dist, int W, int H) {
        switch (dir) {
            case 1: return dist;
            case 2: return 2 * W + H - dist;
            case 3: return 2 * (W + H) - dist;
            case 4: return W + dist;
        }
        return 0;
    }
}
