import java.util.*;
import java.io.*;

//0<=n<=100000
//0<=k<=100000
public class Main {
    static final int MAX = 1000000;
    static int n,k;
    static int[] dist; //n에서 x까지 가는 최단 거리
    static int[] ways; //n에서 x까지 최단 시간 도달 경로 개수
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      dist = new int[MAX+1];
      ways = new int[MAX+1];
      Arrays.fill(dist, -1);
      
      // n>k 일때는 무조건 뒤로만 걷는게 최단
      if(n>=k){
        System.out.println(n-k);
        System.out.println(1);
        return;
      }
      
      bfs();
      System.out.println(dist[k]);
      System.out.println(ways[k]);
  }
  
   static void bfs(){
    Deque<Integer> q = new ArrayDeque<>();
    dist[n] = 0;
    ways[n] = 1;
    q.add(n);
    
    while(!q.isEmpty()){
      int cur = q.poll();
      
      //이미 k까지의 최단 거리를 구했고, k보다 현재 위치가 더 멀다면
      if(dist[k] != -1 && dist[cur] > dist[k]) continue;
      
      int[] nexts = {cur-1, cur+1, cur*2};
      for(int nx : nexts){
        if(nx<0 || nx>MAX) continue;
        
        //처음 구하는거라면
        if(dist[nx] == -1){
          dist[nx] = dist[cur]+1;
          ways[nx] = ways[cur];
          q.add(nx);
        } else if(dist[nx] == dist[cur]+1){
          ways[nx] += ways[cur];
        }
      }
    }
  }
}