import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      //이항계수 구하기
      //nCk
      
      int p = 1;
      int q = 1;
      
      for(int i=0; i<k; i++) p*=(n-i);
      for(int i=1; i<=k; i++) q*=i;
      
      int sum = p/q;
      System.out.println(sum);
  }
}