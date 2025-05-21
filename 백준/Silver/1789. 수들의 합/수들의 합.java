import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      long n = Long.parseLong(br.readLine());
      
      int cnt = 0;
      int index = 1;
      while(true){
        if(index > n){
          break;
        }
        n-=index;
        cnt++;
        index++;
      }
      System.out.println(cnt);
  }
}