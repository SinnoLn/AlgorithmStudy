import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        int ans = twoPointer();
        System.out.println(ans);
    }

    static int twoPointer() {
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;

        while (l < n) {
            while (r < n && nums[r] - nums[l] < m) r++;
            if (r == n) break;
            ans = Math.min(ans, nums[r] - nums[l]);
            l++;
        }
        return ans;
    }
}
