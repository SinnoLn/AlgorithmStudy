import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      // 500,000
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        pq.add(Integer.parseInt(st.nextToken()));
      }
      
      StringBuilder sb = new StringBuilder();
      while(!pq.isEmpty()){
        sb.append(pq.poll()).append(" ");
      }
      System.out.println(sb.toString());
  }
}