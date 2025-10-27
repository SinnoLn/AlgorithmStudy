import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for(int i=0; i<5; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        if(arr[3]-arr[1] >= 4) System.out.println("KIN");
        else {
          int sum = 0;
          for(int i=1; i<4; i++) sum+=arr[i];
          System.out.println(sum);
        }
      }
  }
}