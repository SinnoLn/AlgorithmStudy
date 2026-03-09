import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int num = (int)Math.sqrt(n);
      
      boolean[] isNotPrime = new boolean[n+1];
      isNotPrime[0] = isNotPrime[1] = true;
      for(int i=2; i<=num; i++){
        for(int j=i*i; j<=n; j+=i){
          isNotPrime[j] = true;
        }
      }
      
      int minNum = Integer.MAX_VALUE;
      int sum = 0;
      
      for(int i=m; i<=n; i++){
        if(isNotPrime[i]) continue;
        minNum = Math.min(minNum, i);
        sum+=i;
      }
      
      if(minNum == Integer.MAX_VALUE) System.out.println(-1);
      else{
        System.out.println(sum);
        System.out.println(minNum);
      }
    }
}