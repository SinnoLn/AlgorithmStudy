import java.util.*;
import java.io.*;

public class Solution {
    static final int MOD = 1234567891;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        factorial = new long[1000001];
        factorial[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        for (int t = 1; t <= test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long denominator = (factorial[r] * factorial[n - r]) % MOD;
            long inverse = modPow(denominator, MOD - 2, MOD);
            long answer = (factorial[n] * inverse) % MOD;

            System.out.println("#" + t + " " + answer);
        }
    }

    static long modPow(long a, long b, int mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) result = (result * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }
}
