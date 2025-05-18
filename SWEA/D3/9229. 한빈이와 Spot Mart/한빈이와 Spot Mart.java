import java.util.*;
import java.io.*;

public class Solution {
    static List<Integer> snacks;
    static Map<Integer,Integer> memo;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        snacks = new ArrayList<>();
        memo = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          int snack = Integer.parseInt(st.nextToken());
          if(snack >= m) continue;
          if(!memo.containsKey(snack)){
            memo.put(snack, 1);
            snacks.add(snack);
          }
          else if(memo.get(snack) > 2) continue;
          else if(memo.get(snack) == 1){
            memo.put(snack, memo.get(snack)+1);
            snacks.add(snack);
          } 
        }
        
        int ans = searchMaxWeight(m);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int searchMaxWeight(int limit){
    int maxWeight = -1;
    for(int i=0; i<snacks.size()-1; i++){
      for(int j=i+1; j<snacks.size(); j++){
        int sum = snacks.get(i) + snacks.get(j);
        if(sum == limit) return sum;
        else if(sum < limit) maxWeight = Math.max(maxWeight, sum);
      }
    }
    return maxWeight;
  }
}