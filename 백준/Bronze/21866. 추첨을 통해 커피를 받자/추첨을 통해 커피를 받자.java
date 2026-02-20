import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      List<Integer> list = Arrays.asList(100,100,200,200,300,300,400,400,500);
      
      int sum = 0;
      for(int i=0; i<9; i++){
        int num = Integer.parseInt(st.nextToken());
        if(num>list.get(i)){
          System.out.println("hacker");
          return;
        }
        sum+=num;
      }
      
      if(sum>=100) System.out.println("draw");
      else System.out.println("none");
    }
}