import java.util.*;
import java.io.*;

//0 ~ 99만
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        List<Integer> num = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          int tmp = Integer.parseInt(st.nextToken());
          num.add(tmp);
        }
        
        int op = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<op; i++){
          char x = st.nextToken().charAt(0);
          int p = Integer.parseInt(st.nextToken());
          int cnt = Integer.parseInt(st.nextToken());
          
          for(int j=0; j<cnt; j++){
            int tmp = Integer.parseInt(st.nextToken());
            num.add(p+j,tmp);
          }
        }
        
        System.out.print("#"+t+" ");
        for(int i=0; i<10; i++){
          System.out.print(num.get(i)+" ");
        }
        System.out.println();
      }
  }
}