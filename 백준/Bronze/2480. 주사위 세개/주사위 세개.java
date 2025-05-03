import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      
      int money = 0;
      
      if(a==b && b==c && a==c) money = 10000+a*1000;
      else if(a==b || b==c || a==c ){
        if(a==b) money = 1000+a*100;
        else if(b==c) money = 1000+c*100;
        else money = 1000+a*100;
      }
      else{
        int max = Math.max(Math.max(a,b),c);
        money = max*100;
      }
      
      System.out.println(money);
      sc.close();
  }
}