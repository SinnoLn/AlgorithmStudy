import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      if(isPossible(n,m)) System.out.println("Yes");
      else System.out.println("No");
    }
    
    static boolean isPossible(int n, int price){
      int money = 100*n;
      if(money>=price) return true;
      else return false;
    }
}