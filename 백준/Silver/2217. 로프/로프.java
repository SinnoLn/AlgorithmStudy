import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] rope = new int[n];
      for(int i=0; i<n; i++){
        rope[i] = Integer.parseInt(br.readLine());
      }
      
      Arrays.sort(rope);
      
      int weight = 0;
      for(int i=0; i<n; i++){
        weight = Math.max(weight, rope[i]*(n-i));
      }
      System.out.println(weight);
  }
}