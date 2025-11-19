import java.util.*;
import java.io.*;

public class Main {
  static int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int i=0; i<10; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;
        int diff = b-a;
        
        int idx = 0;
        for(int j=0; j<=diff/2; j++){
          int tmp = arr[a+idx];
          arr[a+idx] = arr[b-idx];
          arr[b-idx] = tmp;
          idx++;
        }
      }
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<20; i++) sb.append(arr[i]).append(" ");
      System.out.println(sb.toString());
  }
}