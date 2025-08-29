import java.util.*;
import java.io.*;

public class Main {
  //n은 10억 이상
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      //1-7-19-37-61 (6씩 증가하는 등차수열)
      
      int num = 1;
      int ans = 1;
      int add = 6;
      
      while(true){
        if(n<=num) break;
        num+=add;
        add+=6;
        ans++;
      }
      
      System.out.println(ans);
  }
}