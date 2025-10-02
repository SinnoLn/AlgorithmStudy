import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      List<Integer> coins = new ArrayList<>();
      for(int i=0; i<n; i++){
        int coin = Integer.parseInt(br.readLine());
        if(coin>k) continue;
        coins.add(coin);
      }
      
      //로직 시작
      int ans = 0;
      for(int t=coins.size()-1; t>-1; t--){
        if(k==0) break;
        int tmp = k/coins.get(t);
        ans+=tmp;
        k-=coins.get(t)*tmp;
      }
      
      System.out.println(ans);
  }
}