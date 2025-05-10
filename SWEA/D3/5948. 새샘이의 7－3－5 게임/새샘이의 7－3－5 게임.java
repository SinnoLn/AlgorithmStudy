import java.util.*;
import java.io.*;

public class Solution {
    static Set<Integer> set;
    static int[] num;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        num = new int[7];
        set = new TreeSet<>(Collections.reverseOrder());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<7; i++) num[i] = Integer.parseInt(st.nextToken());
        backtrack(0,0,0);
        
        List<Integer> list = new ArrayList<>(set);
        System.out.println("#"+t+" "+list.get(4));
      }
  }
  
  static void backtrack(int start, int sum, int depth){
    if(depth == 3){
      set.add(sum);
      return;
    }
    for(int i=start; i<num.length; i++){
      backtrack(i+1, sum+num[i], depth+1);
    }
  }
}