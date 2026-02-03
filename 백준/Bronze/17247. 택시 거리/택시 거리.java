import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      List<int[]> list = new ArrayList<>();
      
      for(int i=0; i<y; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<x; j++){
          int num = Integer.parseInt(st.nextToken());
          if(num == 1) list.add(new int[]{i,j});
        }
      }
      
      int ans = Math.abs(list.get(1)[0] - list.get(0)[0]) + Math.abs(list.get(1)[1] - list.get(0)[1]);
      System.out.println(ans);
    }
}