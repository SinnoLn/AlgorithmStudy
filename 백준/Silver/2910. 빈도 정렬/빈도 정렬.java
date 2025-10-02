import java.util.*;
import java.io.*;

public class Main {
    static class Info{
      int num;
      int idx;
      int cnt;
      
      public Info(int num, int idx, int cnt){
        this.num = num;
        this.idx = idx;
        this.cnt = cnt;
      }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      
      Map<Integer,Integer> map = new HashMap<>();
      List<Info> list = new ArrayList<>();
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(st.nextToken());
        
        if(map.containsKey(num)){
          int pos = map.get(num);
          list.get(pos).cnt++;
        }
        else {
          map.put(num,list.size());
          list.add(new Info(num,i,1));
        }
      }
      
      Collections.sort(list, (a,b)->{
        if(a.cnt==b.cnt) return a.idx-b.idx;
        return b.cnt-a.cnt;
      });
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<list.size(); i++){
        int num = list.get(i).cnt;
        for(int j=0; j<num; j++){
          sb.append(list.get(i).num).append(" ");
        }
      }
      System.out.println(sb.toString());
  }
}