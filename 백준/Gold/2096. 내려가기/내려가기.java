import java.io.*;

class Main {
    final static int MAX_SIZE = 3;

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] maxDP = new int[n][MAX_SIZE];
        int[][] minDP = new int[n][MAX_SIZE];

        for (int j = 0; j < MAX_SIZE; j++) {
            maxDP[0][j] = minDP[0][j] = read();
        }

        for (int i = 1; i < n; i++) {
            int a = read(), b = read(), c = read();

            maxDP[i][0] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + a;
            maxDP[i][1] = Math.max(maxDP[i - 1][0], Math.max(maxDP[i - 1][1], maxDP[i - 1][2])) + b;
            maxDP[i][2] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + c;

            minDP[i][0] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + a;
            minDP[i][1] = Math.min(minDP[i - 1][0], Math.min(minDP[i - 1][1], minDP[i - 1][2])) + b;
            minDP[i][2] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + c;
        }
        int maxAns = Math.max(maxDP[n-1][0], Math.max(maxDP[n-1][1], maxDP[n-1][2]));
        int minAns = Math.min(minDP[n-1][0], Math.min(minDP[n-1][1], minDP[n-1][2]));

        System.out.println(maxAns +" "+ minAns);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) 
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}