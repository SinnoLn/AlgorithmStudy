import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Map<Integer, Integer> map;
      int[] things;
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //할인가를 구하는것
        map = new HashMap<>();
        things = new int[n*2];
        for(int i=0; i<n*2; i++){
          int item = Integer.parseInt(st.nextToken());
          if(map.containsKey(item)) map.put(item, map.get(item)+1);
          else map.put(item, 1);
          things[i] = item;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=2*n-1; i>-1; i--){
          if(!map.containsKey(things[i])) continue;
          int tmp = (int)(things[i]*0.75);
          if(map.containsKey(tmp)){
            if(map.get(tmp)>0){
              map.put(tmp, map.get(tmp)-1);
              map.put(things[i], map.get(things[i])-1);
              list.add(tmp);
            } 
            if(map.get(tmp) == 0) map.remove(tmp);
            if(map.get(things[i]) == 0) map.remove(things[i]);
            
          } 
        }
        
        StringBuilder sb = new StringBuilder();
        System.out.print("#"+t+" ");
        for(int i=n-1; i>-1; i--) {
          sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString());
      }
  }
}