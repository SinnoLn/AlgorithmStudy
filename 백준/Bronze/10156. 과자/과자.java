import java.util.*;
import java.io.*;

public class Main {
  //과자 1개 k, 과자 개수 n,돈 액수 m
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int k = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      int ans = k*n-m;
      int sum = 0;
      if(ans>0) sum = ans; 
      
      System.out.println(sum);
  }
}