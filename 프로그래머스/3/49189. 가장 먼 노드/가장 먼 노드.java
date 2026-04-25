import java.io.*;
import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        bfs();
        
        Arrays.sort(dist);
        int maxNum = dist[n];
        answer++;
        
        for(int i=n-1; i>=0; i--){
            if(maxNum == dist[i]) answer++;
            else break;
        }
        return answer;
    }
    
    static void bfs(){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        dist[1] = 0;
        
        while(!dq.isEmpty()){
            int node = dq.poll();
            
            for(int nextNode : graph.get(node)){
                if(dist[nextNode] != -1) continue;
                dist[nextNode] = dist[node] + 1;
                dq.add(nextNode);

            }
        }
    }
}