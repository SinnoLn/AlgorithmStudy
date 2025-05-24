import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static long min = Long.MAX_VALUE;
    static int[] result = new int[3];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      arr = new int[n];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
      Arrays.sort(arr);
      
      for(int i=0; i<n-2; i++){
        binarySearch(i);
      }
      System.out.println(result[0] + " " + result[1] + " " + result[2]);
  }
  
  static void binarySearch(int fixed){
    int left = fixed+1;
    int right = n-1;
    
    while(left<right){
        long sum = (long)arr[fixed] + arr[left] + arr[right];
        
        if(Math.abs(sum) < min){
          min = Math.abs(sum);
          result[0] = arr[fixed];
          result[1] = arr[left];
          result[2] = arr[right];
        }
        if (sum < 0) left++;
        else right--;
      }
  }
}