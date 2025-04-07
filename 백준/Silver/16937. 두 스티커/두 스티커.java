import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        List<int[]> stickers = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int sh = Integer.parseInt(st.nextToken());
            int sw = Integer.parseInt(st.nextToken());
            
            stickers.add(new int[]{sh, sw});
        }

        int maxArea = 0;
        
        for(int i=0; i<N-1; i++){
            int[] s1 = stickers.get(i);
            for(int j=i+1; j<N; j++){
                int[] s2 = stickers.get(j);

                int[][] s1Rotations = {{s1[0], s1[1]}, {s1[1], s1[0]}};
                int[][] s2Rotations = {{s2[0], s2[1]}, {s2[1], s2[0]}};

                for (int[] r1 : s1Rotations) {
                    for (int[] r2 : s2Rotations) {
                        int h1 = r1[0], w1 = r1[1];
                        int h2 = r2[0], w2 = r2[1];

                        if (Math.max(h1, h2) <= H && w1 + w2 <= W) {
                            maxArea = Math.max(maxArea, h1 * w1 + h2 * w2);
                        }

                        if (Math.max(w1, w2) <= W && h1 + h2 <= H) {
                            maxArea = Math.max(maxArea, h1 * w1 + h2 * w2);
                        }
                    }
                }
            }
        }
        System.out.println(maxArea);
    }
}