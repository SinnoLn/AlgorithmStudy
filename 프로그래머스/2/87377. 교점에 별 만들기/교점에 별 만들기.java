import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();

        long minX = Long.MAX_VALUE; 
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        int n = line.length;

        for (int i = 0; i < n - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for (int j = i + 1; j < n; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long denom = a * d - b * c;
                
                if (denom == 0) continue;

                long xNumer = b * f - e * d;
                long yNumer = e * c - a * f;

                if (xNumer % denom != 0 || yNumer % denom != 0) continue;

                long x = xNumer / denom;
                long y = yNumer / denom;

                points.add(new long[]{x, y});

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] board = new char[height][width];
        for (int r = 0; r < height; r++) {
            Arrays.fill(board[r], '.');
        }

        for (long[] p : points) {
            long x = p[0];
            long y = p[1];

            int col = (int) (x - minX);
            int row = (int) (maxY - y);

            board[row][col] = '*';
        }

        String[] answer = new String[height];
        for (int r = 0; r < height; r++) {
            answer[r] = new String(board[r]);
        }
        return answer;
    }
}