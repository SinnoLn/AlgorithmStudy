import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      int[] change = {25,10,5,1};
      for(int t=1; t<=test; t++){
        int money = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int c : change){
          sb.append(money/c).append(" ");
          money%=c;
        }
        System.out.println(sb.toString());
      }
      
  }
}