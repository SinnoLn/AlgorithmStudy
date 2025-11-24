import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int ans = findAnswer(n);
      System.out.println(ans);
  }
  
  static int findAnswer(int n){
    while(true){
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        if(sb.toString().equals(sb.reverse().toString())){
          if(isPrime(n)){
            return n;
          }
        }
        n++;
      }
  }
  static boolean isPrime(int n){
    if(n == 1) return false;
    if(n == 2) return true;
    for(int i=2; i<=Math.sqrt(n); i++){
      if(n%i == 0) return false;
    }
    return true;
  }
}