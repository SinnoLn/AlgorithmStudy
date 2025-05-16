import java.util.*;
import java.io.*;

public class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        pq.clear();
        int n = Integer.parseInt(br.readLine());
        bw.write("#"+t+" ");
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            
            if(op == 1){
              int x = Integer.parseInt(st.nextToken());
              pq.add(x);
            }
            else if(op == 2){
              if(!pq.isEmpty()){
                bw.write(pq.peek()+" ");
                pq.poll();
              }
              else bw.write(-1 + " ");
            }
        }
        bw.write("\n");
        bw.flush();
      }
       bw.close();
      br.close();
  }
}