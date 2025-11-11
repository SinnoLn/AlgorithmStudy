import java.util.*;
import java.io.*;

//치킨2 -> 콜라2 or 맥주1
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int chicken = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int coke = Integer.parseInt(st.nextToken());
      int beer = Integer.parseInt(st.nextToken());
      
      int sum = coke/2 + beer;

      if(chicken>sum) System.out.println(sum);
      else System.out.println(chicken);
  }
}