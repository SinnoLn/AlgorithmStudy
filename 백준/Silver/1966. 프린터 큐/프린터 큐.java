import java.util.*;
import java.io.*;

public class Main {
    static class Docs{
      int priority;
      int idx;
      
      public Docs(int priority, int idx){
        this.priority = priority;
        this.idx = idx;
      }
    }
    static int[] important;
    static int n,m;
    static Deque<Docs> dq;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
  
      for(int t=0; t<test; t++){
        dq = new ArrayDeque<>();
        important = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int printed = 0;
        
        for(int i=0; i<n; i++){
          int num = Integer.parseInt(st.nextToken());
          dq.add(new Docs(num,i));
          important[num]++;
        }
        
        while(!dq.isEmpty()){
          Docs curr = dq.poll();
          if(hasHigher(curr.priority)){
            dq.addLast(curr);
          }
          else {
            printed++;
            important[curr.priority]--;
            if(curr.idx == m){
              System.out.println(printed);
              break;
            }
          }
        }
      }
  }
  static boolean hasHigher(int priority){
    for(int p = priority+1; p<10; p++){
      if(important[p]>0) return true;
    }
    return false;
  }
}