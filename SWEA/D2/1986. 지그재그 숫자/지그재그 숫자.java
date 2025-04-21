import java.util.*;
import java.io.*;

public class Solution {
  //1부터 n까지의 숫자
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int t = Integer.parseInt(br.readLine());
      for(int test = 1; test<=t; test++){
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=1; i<=n; i++){
          if(i%2==0) sum+=-i;
          else sum+=i;
        }
        System.out.println("#"+test+" "+sum);
      }
    }
}