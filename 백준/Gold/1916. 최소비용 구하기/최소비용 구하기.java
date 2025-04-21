import java.util.*;
import java.io.*;

public class Main {
    //n개의 도시
    //m개의 버스
    //a번째 도시에서 b번째 도시까지 가는데 드는 버스 비용을 최소화
    //도시는 1부터 n까지
    //다익스트라 알고리즘
    //우선순위 큐
    static class Node implements Comparable<Node> {
      int city;
      int cost;
      
      public Node(int city, int cost){
        this.city = city;
        this.cost = cost;
      }
      
      @Override
      public int compareTo(Node o){
        return this.cost - o.cost; //최소비용 먼저 나오게
      }
    };
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      
      //출발지 번호, 도착지 번호, 버스 비용
      List<List<Node>> g = new ArrayList<>();
      for(int i=0; i<=n; i++){
        g.add(new ArrayList<>());
      }
      
      for(int i=0; i<m; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        
        g.get(from).add(new Node(to,cost));
      }
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      
      int[] dist = new int[n+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[start] = 0;
      
      PriorityQueue<Node> pq = new PriorityQueue<>();
      pq.offer(new Node(start, 0));
      
      while(!pq.isEmpty()){
        Node curr = pq.poll();
        int currCity = curr.city;
        int currCost = curr.cost;
        
        if(dist[currCity] < currCost) continue;
        
        for(Node next : g.get(currCity)){
          int newCost = currCost + next.cost;
          if(newCost < dist[next.city]){
            dist[next.city] = newCost;
            pq.offer(new Node(next.city, newCost));
          }
        }
      }
      System.out.println(dist[end]);
  }
}