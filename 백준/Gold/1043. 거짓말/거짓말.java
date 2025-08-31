import java.util.*;
import java.io.*;

public class Main {
    static class Dsu{
      int[] parent;
      int[] rank;
      
      public Dsu(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
          parent[i] = i;
          rank[i] = 0;
        }
      }
      
      int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
      }
      
      void union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        if(ra == rb) return;
        
        if(rank[ra] < rank[rb]) parent[ra] = rb;
        else if(rank[ra] > rank[rb]) parent[rb] = ra;
        else {
          parent[rb] = ra;
          rank[ra]++;
        }
      }
    }
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      
      int[] truth = new int[k];
      for(int i=0; i<k; i++) truth[i] = Integer.parseInt(st.nextToken());
      
      List<int[]> parties = new ArrayList<>();
      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int[] p = new int[c];
        
        for(int j=0; j<c; j++) p[j] = Integer.parseInt(st.nextToken());
        parties.add(p);
      }
      
      if(k ==0) {
        System.out.println(m);
        return;
      }
      
      Dsu dsu = new Dsu(n);
      for(int[] p : parties) {
        int base = p[0];
        for(int i=1; i<p.length; i++) dsu.union(base, p[i]);
      }
      
        boolean[] truthRoot = new boolean[n+1];
        for(int t : truth) truthRoot[dsu.find(t)] = true;
        
        int ans = 0;
        outer:
        for(int[] part : parties){
          for(int x : part){
            if(truthRoot[dsu.find(x)]) continue outer;
          }
          ans++;
        }
        System.out.println(ans);
  }
}