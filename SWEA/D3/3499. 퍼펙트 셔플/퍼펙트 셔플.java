import java.util.*;
import java.io.*;

public class Solution {
    static Queue<String> deckA = new LinkedList<>();
    static Queue<String> deckB = new LinkedList<>();
    static int aCnt, bCnt;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        aCnt = n/2;
        bCnt = n/2;
        if(n%2 != 0) aCnt++;
        
        for(int i=0; i<aCnt; i++){
          String s = st.nextToken();
          deckA.add(s);
        }
        for(int i=0; i<bCnt; i++){
          String s = st.nextToken();
          deckB.add(s);
        }
        
        System.out.print("#"+t+" ");
        StringBuilder sb = new StringBuilder();
        
        int cnt = n;
        while(true){
          sb.append(deckA.poll()).append(" ");
          cnt--;
          if(cnt == 0) break;
          
          sb.append(deckB.poll()).append(" ");
          cnt--;
          if(cnt == 0) break;
        }
        System.out.print(sb.toString());
        System.out.println();
        
        deckA.clear();
        deckB.clear();
      }
  }
}