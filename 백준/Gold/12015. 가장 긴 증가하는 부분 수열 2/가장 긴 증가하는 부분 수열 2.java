import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] arr = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
      
      List<Integer> lis = new ArrayList<>();
      
      for (int num : arr) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -(idx + 1);
            if (idx == lis.size()) lis.add(num);
            else lis.set(idx, num);
      }
      System.out.println(lis.size());
  }
}