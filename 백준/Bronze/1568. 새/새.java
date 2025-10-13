import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      int time = 0;
      int num = 0;
      while(true){
        if(n==0) break;
        if(n<=num){
          num = 0;
          continue;
        }
        time++;
        num++;
        n-=num;
      }
      
      System.out.println(time);
  }
}