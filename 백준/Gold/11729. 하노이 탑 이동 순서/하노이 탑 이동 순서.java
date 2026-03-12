import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<int[]> moves = new ArrayList<>();
    static int count;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      sb.append((int) (Math.pow(2, n) - 1)).append('\n');
      hanoi(n,1,3,2);
      
      System.out.println(sb.toString());
    }
    
    static void hanoi(int n, int start, int end, int sub){
      if(n==1){
        sb.append(start).append(" ").append(end).append('\n');
        return;
      }
      
      hanoi(n-1,start, sub, end);
      
      sb.append(start).append(" ").append(end).append('\n');
      
      hanoi(n-1,sub,end,start);
    }
}