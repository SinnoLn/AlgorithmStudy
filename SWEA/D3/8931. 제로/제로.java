import java.util.*;
import java.io.*;

public class Solution {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        stack.clear();
        
        for(int i=0; i<n; i++){
          int num = Integer.parseInt(br.readLine());
          if(num == 0) stack.pop();
          else stack.add(num);
        }
        
        int sum = 0;
        for(int i : stack) sum+=i;
        System.out.println("#"+t+" "+sum);
      }
  }
}