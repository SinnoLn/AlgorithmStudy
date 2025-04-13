import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  
        int an = Integer.parseInt(st.nextToken()); 
        int bn = Integer.parseInt(st.nextToken()); 

        Integer[] a = new Integer[an];
        Integer[] b = new Integer[bn];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < an; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bn; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());

        long[] aSum = new long[an + 1];
        long[] bSum = new long[bn + 1];

        for (int i = 0; i < an; i++) {
            aSum[i + 1] = aSum[i] + a[i];
        }
        for (int i = 0; i < bn; i++) {
            bSum[i + 1] = bSum[i] + b[i];
        }

        long maxBeauty = 0;
        // bCnt: 선택할 B타일 개수 (0 ~ bn)
        for (int bCnt = 0; bCnt <= bn; bCnt++) {
            int bCover = 2 * bCnt;
            int remain = n - bCover;

            if (remain < 0) break;
            if (remain > an) continue; // A타일 부족

            long totalBeauty = bSum[bCnt] + aSum[remain];
            maxBeauty = Math.max(maxBeauty, totalBeauty);
        }

        System.out.println(maxBeauty);
    }
}