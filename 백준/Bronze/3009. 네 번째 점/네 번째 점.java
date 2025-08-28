import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int ansX, ansY;

        if (x[0] == x[1]) ansX = x[2];
        else if (x[0] == x[2]) ansX = x[1];
        else ansX = x[0];

        if (y[0] == y[1]) ansY = y[2];
        else if (y[0] == y[2]) ansY = y[1];
        else ansY = y[0];

        System.out.println(ansX + " " + ansY);
    }
}