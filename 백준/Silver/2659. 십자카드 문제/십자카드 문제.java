import java.util.*;
import java.io.*;

public class Main {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int initial = num[0]*1000 + num[1]*100 + num[2]*10 + num[3];
        int target = getClockNum(initial);

        int ans = 0;
        for (int i = 1111; i <= 9999; i++) {
            if (String.valueOf(i).contains("0")) continue;
            int clockNum = getClockNum(i);
            if (!set.contains(clockNum)) {
                set.add(clockNum);
                ans++;
            }
            if (clockNum == target) break;
        }
        System.out.println(ans);
    }

    static int getClockNum(int num) {
        int min = num;
        int curr = num;
        for (int i = 0; i < 3; i++) {
            curr = (curr % 1000) * 10 + (curr / 1000);
            min = Math.min(min, curr);
        }
        return min;
    }
}