import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Stack<Integer> stack = new Stack<>();
      
      int k = Integer.parseInt(br.readLine());
      long sum = 0L;
      
      for(int i=0; i<k; i++){
        int n = Integer.parseInt(br.readLine());
        if(n == 0){
          int num = stack.pop();
          sum-=num;
        }
        else{
          stack.push(n);
          sum+=n;
        }
      }
      System.out.println(sum);
    }
}