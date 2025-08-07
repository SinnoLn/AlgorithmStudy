import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int[] dirs = new int[6];
        int[] lengths = new int[6];

        int maxWidth = 0;
        int maxHeight = 0;
        int maxWidthIdx = -1;
        int maxHeightIdx = -1;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dirs[i] = Integer.parseInt(st.nextToken());
            lengths[i] = Integer.parseInt(st.nextToken());

            if (dirs[i] == 1 || dirs[i] == 2) {
                if (maxWidth < lengths[i]) {
                    maxWidth = lengths[i];
                    maxWidthIdx = i;
                }
            } else {
                if (maxHeight < lengths[i]) {
                    maxHeight = lengths[i];
                    maxHeightIdx = i;
                }
            }
        }

        int bigArea = maxWidth * maxHeight;

        int smallWidth = Math.abs(lengths[(maxHeightIdx + 5) % 6] - lengths[(maxHeightIdx + 1) % 6]);
        int smallHeight = Math.abs(lengths[(maxWidthIdx + 5) % 6] - lengths[(maxWidthIdx + 1) % 6]);
        
        int smallArea = smallWidth * smallHeight;
        
        int totalMelons = (bigArea - smallArea) * k;

        System.out.println(totalMelons);
    }
}