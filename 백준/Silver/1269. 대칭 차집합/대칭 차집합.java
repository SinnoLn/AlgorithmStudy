import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      //20
      Set<Integer> setA = new HashSet<>();
      Set<Integer> setB = new HashSet<>();
      
      int[] arrA = new int[a];
      int[] arrB = new int[b];
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<a; i++){
        arrA[i] = Integer.parseInt(st.nextToken());
        setA.add(arrA[i]);
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<b; i++){
        arrB[i] = Integer.parseInt(st.nextToken());
        setB.add(arrB[i]);
      }
      
      int cnt1 = 0;
      int cnt2 = 0;
      for(int i=0; i<b; i++){
        if(!setA.contains(arrB[i])) cnt2++;
      }
      for(int i=0; i<a; i++){
        if(!setB.contains(arrA[i])) cnt1++;
      }
      
      System.out.println(cnt1+cnt2);
  }
}