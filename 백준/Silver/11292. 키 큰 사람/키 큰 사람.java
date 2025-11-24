import java.util.*;
import java.io.*;

public class Main {
    static class Info{
      int idx;
      double height;
      String name;
      
      public Info(int idx, double height, String name){
        this.idx = idx;
        this.height = height;
        this.name = name;
      }
    }
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      while(true){
        int n = Integer.parseInt(br.readLine());
        if(n == 0) break;
        
        List<Info> list = new ArrayList<>();
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          String name = st.nextToken();
          double height = Double.parseDouble(st.nextToken());
          
          list.add(new Info(i,height,name));
        }
        
        Collections.sort(list, (a, b) -> {
          if (Double.compare(a.height, b.height) == 0) {
              return Integer.compare(a.idx, b.idx);
          }
          return Double.compare(b.height, a.height);
        });
        
        double priHeight = list.get(0).height;
        System.out.print(list.get(0).name+" ");
        for(int i=1; i<list.size(); i++){
          if(Double.compare(priHeight,list.get(i).height) == 0) System.out.print(list.get(i).name+" ");
          else break;
        }
        System.out.println();
      }
  }
}