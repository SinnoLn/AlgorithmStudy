import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];
        List<String> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) list[i] = st.nextToken();
        
        int mid = (n + 1) / 2;
        int i = 0;
        int j = mid; 
        while (i < mid || j < n) {
            if (i < mid) result.add(list[i++]);
            if (j < n) result.add(list[j++]);
        }
        
        System.out.print("#" + t + " ");
        for (String card : result) System.out.print(card + " ");
        System.out.println();
      }
  }
}