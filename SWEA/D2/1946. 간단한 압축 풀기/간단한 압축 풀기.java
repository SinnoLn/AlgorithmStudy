import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            System.out.println("#"+t);

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int count = Integer.parseInt(st.nextToken());

                for (int j = 0; j < count; j++) {
                    sb.append(c);
                    if (sb.length() == 10) {
                        System.out.println(sb.toString());
                        sb.setLength(0);
                    }
                }
            }

            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }
        }
    }
}