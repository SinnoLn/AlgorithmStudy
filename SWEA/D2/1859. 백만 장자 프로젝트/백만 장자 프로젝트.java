import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] prices = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = 0;
            long profit = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    profit += maxPrice - prices[i];
                }
            }
            
            System.out.println("#" + t + " " + profit);
        }
    }
}