import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] position = new int[M];
        int distance = 0;
        position[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<M; i++){
            position[i] = Integer.parseInt(st.nextToken());
            distance = Math.max(distance, Math.abs(position[i-1] - position[i]));
        }
        int firstDistance = position[0];
        int lastDistance = N - position[M-1];

        distance = distance/2 + distance%2;
        
        int ans = Math.max(firstDistance, Math.max(distance, lastDistance));
        System.out.println(ans);
    }
}