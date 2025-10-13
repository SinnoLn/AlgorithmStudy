import java.util.*;
import java.io.*;

//최소 공배수
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=0; t<test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        System.out.println(lcm(a,b));
      }
  }
  static int gcd(int a, int b){
    while(b!=0){
      int r = a%b;
      a=b;
      b=r;
    }
    return a;
  }
  
  static int lcm(int a, int b){
    return a*b/gcd(a,b);
  }
}