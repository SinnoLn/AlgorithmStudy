import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //"666"
      int n = Integer.parseInt(br.readLine());
      int cnt = 0;
      int ans = 0;
      
      //완전탐색
      for(int i=666; i<=Integer.MAX_VALUE; i++){
        if(cnt == n){
          ans = i;
          break;
        }
        String s = Integer.toString(i);
        if(s.contains("666")) cnt++;
      }
      
      System.out.println(ans-1);
  }
}