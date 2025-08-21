import java.util.*;
import java.io.*;

// 재료 n개
// 신맛 s(곱) 쓴맛 b(합)
// 10억 이하
// 재료를 1개이상 전부 사용하여 계산후 가장 차이가 작은 요리
public class Main {
    static int n;
    static int[] sour;
    static int[] bitter;
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      sour = new int[n];
      bitter = new int[n];
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        sour[i] = Integer.parseInt(st.nextToken());
        bitter[i] = Integer.parseInt(st.nextToken());
      }
      
      dfs(0,1L,0L,false);
      System.out.println(ans);
  }
  
  //최대 재료 10개 부분집합
  static void dfs(int idx, long sProd, long bSum, boolean used){
    
    if(idx == n){
      if(used) ans = Math.min(ans, Math.abs(sProd - bSum));
      return;
    }
    
    dfs(idx + 1, sProd * sour[idx], bSum + bitter[idx], true);
    dfs(idx + 1, sProd, bSum, used);
  }
}