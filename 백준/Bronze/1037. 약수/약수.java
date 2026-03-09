import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] num = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        num[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(num);
      
      long sum = num[0]*num[n-1];
      System.out.println(sum);
    }
}