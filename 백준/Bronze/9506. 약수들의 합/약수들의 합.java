import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //총 10만개의 수
      while(true){
        int n = Integer.parseInt(br.readLine());
        if(n == -1) break;
        
        String ans = isPerfectNum(n);
        System.out.println(ans);
      }
    }
    
    static String isPerfectNum(int n){
      int sum = 0;
      StringBuilder factors = new StringBuilder();
      
      for(int i=1; i<n; i++){
        if(n%i ==0){
          sum+=i;
          if(factors.length() > 0) factors.append(" + ");
          factors.append(i);
        }
      }
        
      if(sum == n) return n + " = " + factors.toString();
      else return n + " is NOT perfect.";
    }
}