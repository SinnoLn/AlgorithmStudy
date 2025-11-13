import java.util.*;
import java.io.*;

//공동 n등
public class Main {
    static class Nation{
      int idx,gold,silver,bronze;
      int rank;
      
      public Nation(int idx, int gold, int silver, int bronze, int rank){
        this.idx = idx;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = rank;
      }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      Nation[] nation = new Nation[n];
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        int id = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        nation[i] = new Nation(id,g,s,b,1);
      }
      
      //커스텀 정렬
      Arrays.sort(nation,(a,b)->{
        if(a.gold != b.gold) return b.gold-a.gold;
        if(a.silver != b.silver) return b.silver-a.silver;
        return b.bronze-a.bronze;
      });
      
      nation[0].rank = 1;
      for(int i=1; i<n; i++){
        Nation curr = nation[i];
        Nation prev = nation[i-1];
        
        //a와 등수 같게
        if(isSame(curr,prev)) curr.rank = prev.rank;
        //인덱스 기준 등수  
        else curr.rank = i+1;
      }
      
      for(int i=0; i<n; i++){
        if(nation[i].idx == k) {
          System.out.println(nation[i].rank);
          return;
        }
      }
  }
      static boolean isSame(Nation a, Nation b){
        if(a.gold != b.gold) return false;
        else if(a.silver != b.silver) return false;
        else if (a.bronze != a.bronze) return false;
        return true;
      }
}