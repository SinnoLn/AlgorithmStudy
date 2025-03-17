import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int left = 0;
        int right = max;
        int ans = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (CanCut(trees, mid, M)) {
                ans = mid; 
                left = mid + 1; 
            } else right = mid - 1;
        }

        System.out.println(ans);
    }
    public static boolean CanCut(int[] trees, int height, int M) {
        long total = 0;
        for (int tree : trees) {
            if (tree > height) {
                total += tree - height;
            }
        }
        return total >= M;
    }
}