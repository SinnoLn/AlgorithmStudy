import java.util.*;
import java.io.*;

public class Solution {
    static int n,m;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          int num = Integer.parseInt(st.nextToken());
          if(num > m) continue;
          list.add(num);
        }
        
        int ans = findMaxWeight();
        System.out.println("#"+t+" "+ans);
        list.clear();
      }
  }
  
  static int findMaxWeight(){
    int max = -1;
    for(int i=0; i<list.size()-1; i++){
      for(int j=i+1; j<list.size(); j++){
        int sum = list.get(i) + list.get(j);
        if(sum == m){
          return m;
        }
        else if(sum <= m) max = Math.max(max, sum);
      }
    }
    return max;
  }
}