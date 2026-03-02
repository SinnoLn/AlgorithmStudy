import java.util.*;
import java.io.*;

public class Main {
    static class Tower{
      int height;
      int idx;
      
      public Tower(int height, int idx){
        this.height = height;
        this.idx = idx;
      }
    }
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      Stack<Tower> stack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      
      for(int i=0; i<n; i++){
        int h = Integer.parseInt(st.nextToken());
        int idx = i+1;
        
        while(!stack.isEmpty() && stack.peek().height < h){
          stack.pop();
        }
        if(stack.isEmpty()) {
          sb.append("0 ");
        }
        else {
          sb.append(stack.peek().idx).append(" ");
        }
        
        stack.push(new Tower(h, idx));
      }
      
      System.out.println(sb.toString());
    }
}