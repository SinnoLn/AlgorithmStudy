import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[] change = {500,100,50,10,5,1};
      int n = Integer.parseInt(br.readLine());
      
      int money = 1000-n;
      int sum = 0;
      for(int c : change){
        sum+=money/c;
        money%=c;
      }
      System.out.println(sum);
  }
}