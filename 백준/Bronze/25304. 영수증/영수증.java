import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int paySum = Integer.parseInt(br.readLine());
      
      int n = Integer.parseInt(br.readLine());
      int cal = 0;
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pay = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        cal+=(pay*cnt);
      }
      
      if(cal == paySum) System.out.println("Yes");
      else System.out.println("No");
  }
}