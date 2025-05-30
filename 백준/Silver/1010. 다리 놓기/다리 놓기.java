import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=0; t<test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //mCn
        long result = 1;
        if (n > m - n) n = m - n;
        for (int i = 1; i <= n; i++) {
            result *= m - i + 1;
            result /= i;
        }
        System.out.println(result);
      }
  }
}