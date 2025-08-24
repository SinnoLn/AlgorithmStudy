import java.util.*;
import java.io.*;


//N 길이의 수에서 왼쪽 기준 N개 전부 소수
public class Main {
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      
      int[] check = {2,3,5,7};
      for(int c : check) dfs(1,c);
      
      bw.flush();
      bw.close();
      br.close();
  }
  
  static void dfs(int len, int num) throws IOException{
    if(!isPrime(num)) return;
    if(len == n){
      bw.write(String.valueOf(num));
      bw.write('\n');
      return;
    }
    int[] check2 = {1,3,7,9};
    for(int c : check2){
      dfs(len+1, num*10+c);
    }
  }
  
  static boolean isPrime(int x){
    if(x<2) return false;
    if(x%2==0) return x==2;
    for(int i=3; i*i<=x; i+=2){
      if(x%i==0) return false;
    }
    return true;
  }
}