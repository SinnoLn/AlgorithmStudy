import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Set<Integer> setA = new HashSet<>();
      Set<Integer> setB = new HashSet<>();
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<a; i++){
        int num = Integer.parseInt(st.nextToken());
        setA.add(num);
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<b; i++){
        int num = Integer.parseInt(st.nextToken());
        setB.add(num);
      }
      
      /////////////////////////////////////////////////
      int cnt = 0;
      Set<Integer> temp = new HashSet<>(setA);
      temp.removeAll(setB);
      cnt+=temp.size();
      
      temp = new HashSet<>(setB);
      temp.removeAll(setA);
      cnt+=temp.size();
      
      System.out.println(cnt);
  }
}