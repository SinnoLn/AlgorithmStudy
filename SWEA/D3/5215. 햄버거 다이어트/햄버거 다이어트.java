import java.util.*;
import java.io.*;

public class Solution {
    static int maxCal, maxPoint, n;
    static List<int[]> ingredient = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        maxCal = Integer.parseInt(st.nextToken());
        ingredient.clear();
        maxPoint = 0;
        
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          int point = Integer.parseInt(st.nextToken());
          int cal = Integer.parseInt(st.nextToken());
          
          ingredient.add(new int[] {point, cal});
        }
        dfs(0,0,0); //조합dfs
        System.out.println("#"+t+" "+maxPoint);
      }
  }
  static void dfs(int cal, int point, int idx){
    if(cal > maxCal) return;
    if(idx == n) {
      maxPoint = Math.max(maxPoint,point);
      return;
    }

    int nextCal = ingredient.get(idx)[1];
    int nextPoint = ingredient.get(idx)[0];
    
    //이 재료를 선택했을 때
    dfs(cal+nextCal, point+nextPoint, idx+1);
    //이 재료를 선택하지 않았을 때
    dfs(cal,point, idx+1);
  }
}