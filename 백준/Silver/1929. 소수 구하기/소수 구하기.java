import java.util.*;
import java.io.*;

//에라토스테네스의 체
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      
      if(e == 1){
        return;
      }
      boolean[] isNotPrime = new boolean[e+1];
      isNotPrime[0] = true;
      isNotPrime[1] = true;
      
      for(int i=2; i*i<=e; i++){
        if(isNotPrime[i]) continue;
        for(int j=i*i; j<=e; j+=i){
          isNotPrime[j] = true;
        }
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i=s; i<=e; i++){
        if(!isNotPrime[i]) {
          sb.append(i).append('\n');
        }
      } 
      System.out.println(sb.toString());
    }
}