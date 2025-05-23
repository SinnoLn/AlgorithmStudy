import java.util.*;
import java.io.*;

public class Solution {
    static class Ingredient{
      int point;
      int cal;
      
      public Ingredient(int point, int cal){
        this.point = point;
        this.cal = cal;
      }
    }
    
    static int ans;
    static Ingredient[] ingredients;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        ingredients = new Ingredient[n];
        ans = 0;
        
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          int p = Integer.parseInt(st.nextToken());
          int c = Integer.parseInt(st.nextToken());
          
          ingredients[i] = new Ingredient(p,c);
        }
        dfs(0,0,0,n,l);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static void dfs(int sum, int cal, int idx, int n, int l){
    if(idx == n){
      ans = Math.max(sum, ans);
      return;
    }
    
    if(cal+ingredients[idx].cal <= l){
      dfs(sum+ingredients[idx].point, cal+ingredients[idx].cal, idx+1, n,l);
    }
    dfs(sum,cal,idx+1, n,l);
  }
}