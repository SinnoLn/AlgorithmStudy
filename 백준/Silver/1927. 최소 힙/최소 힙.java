import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      int n = Integer.parseInt(br.readLine());
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(br.readLine());
        if(num == 0){
          if(!pq.isEmpty()){
            int ans = pq.poll();
            System.out.println(ans);
          }
          else System.out.println(0);
        }
        else pq.add(num);
      }
  }
}