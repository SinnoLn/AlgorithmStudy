import java.util.*;
import java.io.*;

//정해진 칼로리 이하의 가장 높은 포인트의 햄버거 조합
public class Solution {
    static class Ingredient {
      int point;
      int cal;
      
      public Ingredient(int point, int cal){
        this.point = point;
        this.cal = cal;
      }
    };
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int l = Integer.parseInt(st.nextToken());
       
       Ingredient[] ingredient = new Ingredient[n];
       for(int i=0; i<n; i++){
         st = new StringTokenizer(br.readLine());
         int p = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         ingredient[i] = new Ingredient(p,c);
       }
       
       //p[j]: 현재까지 고려한 재료로 
       //j칼로리 이하일 때의 최대 점수
       int[] dp = new int[l+1];
       
       for(int i=0; i<n; i++){
         int point = ingredient[i].point;
         int cal = ingredient[i].cal;
         
         for (int j = l; j >= cal; j--) {
              dp[j] = Math.max(dp[j], dp[j - cal] + point);
         }
       }
       
       int max = 0;
       for (int val : dp) {
           max = Math.max(max, val);
       }
       
       System.out.println("#" + t + " " + max);
      }
  }
}