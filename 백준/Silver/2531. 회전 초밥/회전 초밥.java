import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] kind = new int[d + 1];
        int diff = 0;

        for (int i = 0; i < k; i++) {
            if (kind[arr[i]] == 0) {
                diff++;
            }
            kind[arr[i]]++;
        }

        int maxDiff = (kind[c] == 0) ? diff + 1 : diff;

        int l = 0;
        int r = k - 1;

        for (int i = 0; i < n; i++) {
            kind[arr[l]]--;
            if (kind[arr[l]] == 0) {
                diff--;
            }
            l = (l + 1) % n;

            r = (r + 1) % n;
            if (kind[arr[r]] == 0) {
                diff++;
            }
            kind[arr[r]]++;

            int currentTotal = (kind[c] == 0) ? diff + 1 : diff;
            maxDiff = Math.max(maxDiff, currentTotal);
            
            if (maxDiff == k + 1) break;
        }

        System.out.println(maxDiff);
    }
}