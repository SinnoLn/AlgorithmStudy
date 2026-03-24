import java.util.*;
import java.io.*;

//메모리 확인
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //1500*1500 = 2250000
      //최대 12mb
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
          pq.add(Integer.parseInt(st.nextToken()));
          
          if(pq.size() > n){
            pq.poll();
          }
        }
      }
      
      System.out.println(pq.peek());
    }
}