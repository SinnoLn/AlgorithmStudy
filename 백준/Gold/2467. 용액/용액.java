import java.util.*;
import java.io.*;

class Main {
    public static int[] solvent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        solvent = new int[n];
        solvent[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++) solvent[i] = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        int tmp1 = 0;
        int tmp2 = 0;

        for (int i = 0; i < n - 1; i++) {
            int target = -solvent[i];
            int index = binarySearch(i + 1, n - 1, target);

            if (index < n && index > i && Math.abs(solvent[i] + solvent[index]) < ans) {
                ans = Math.abs(solvent[i] + solvent[index]);
                tmp1 = solvent[i];
                tmp2 = solvent[index];
            }

            if (index - 1 > i && index - 1 < n && Math.abs(solvent[i] + solvent[index - 1]) < ans) {
                ans = Math.abs(solvent[i] + solvent[index - 1]);
                tmp1 = solvent[i];
                tmp2 = solvent[index - 1];
            }
        }
        System.out.println(tmp1 + " " + tmp2);
    }

    public static int binarySearch(int left, int right, int target){
        int low = left;
        int high = right;

        while(low < high){
            int mid = (low + high)/2;
            if(solvent[mid] < target) low = mid+1;
            else high = mid;
        }
         return low;
    }
}