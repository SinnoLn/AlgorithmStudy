import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<test; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        
        if(k>=60){
          sb.append(0).append('\n');
          continue;
        }
        
        long pow = 1L << k;
        long limit = n/pow;
        
        long result = (limit+1)/2;
        
        sb.append(result).append('\n');
      }
      System.out.println(sb.toString());
    }
}