import java.util.*;
import java.io.*;

public class Main {
    static class Info{
      int cost;
      long distance;
      
      public Info(int cost, long distance){
        this.cost = cost;
        this.distance = distance;
      }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //도착지까지 이동 가능한 최소비용
      //long 사용
      int n = Integer.parseInt(br.readLine());
      
      PriorityQueue<Info> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);
      //0->비용, 1->남은거리
      
      //O(10만) + O(10만log10만) + O(10만) 
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] cnt = new int[n-1]; //0-index
      for(int i=0; i<n-1; i++){
        int num = Integer.parseInt(st.nextToken());
        cnt[i] = num;
      }
      
      long[] dist = new long[n];
      for(int i=n-2; i>-1; i--){
        dist[i] = cnt[i] + dist[i+1];
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n-1; i++){
        int num = Integer.parseInt(st.nextToken());
        pq.add(new Info(num, dist[i]));
      }
      
      long pay = 0L;
      long maxDistance = 0;
      while(!pq.isEmpty()){
        Info info = pq.poll();
        if(maxDistance>=info.distance) continue;
        
        pay+=((info.distance-maxDistance)*info.cost);
        maxDistance = info.distance;
      }
      
      System.out.println(pay);
    }
}