import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      String sNum = Integer.toString(num);
      
      int start = num - ((sNum.length())*9);
      int ans = 0;
      if(start<0) start=1;
      for(int i=start; i<num; i++){
        int tmp = i;
        int sum = i;
        while(tmp > 0){
          sum+=(tmp%10);
          tmp/=10;
        }
        if(sum == num){
          ans = i;
          break;
        } 
      }
      System.out.println(ans);
  }
}