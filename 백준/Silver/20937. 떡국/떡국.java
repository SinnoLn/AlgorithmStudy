import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[50001]; //숫자 파악
        int maxNum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            num[tmp]++;
            maxNum = Math.max(maxNum, num[tmp]);
        }

        System.out.println(maxNum);
    }
}