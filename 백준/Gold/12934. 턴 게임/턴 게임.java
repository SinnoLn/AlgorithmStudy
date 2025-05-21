import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long sum = x + y;

        long left = 1;
        long right = 3000000;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = mid * (mid + 1) / 2;

            if (total < sum) left = mid + 1;
            else {
                right = mid - 1;
                result = mid;
            }
        }

        if (result * (result + 1) / 2 != sum) {
            System.out.println(-1);
            return;
        }

        long remaining = x;
        int winCount = 0;
        for (long i = result; i >= 1; i--) {
            if (remaining >= i) {
                remaining -= i;
                winCount++;
            }
        }

        if (remaining == 0) System.out.println(winCount);
        else System.out.println(-1);
    }
}
