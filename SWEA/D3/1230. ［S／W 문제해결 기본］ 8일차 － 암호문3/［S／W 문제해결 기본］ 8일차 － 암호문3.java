import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      for(int t=1; t<=10; t++){
        int n = Integer.parseInt(br.readLine());
        List<Integer> num = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          int tmp = Integer.parseInt(st.nextToken());
          num.add(tmp);
        }
        
        int op = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<op; i++){
          char c = st.nextToken().charAt(0);
          if(c == 'I'){
            int position = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
              int tmp = Integer.parseInt(st.nextToken());
              num.add(position+j, tmp);
            }
          }
          else if(c == 'D'){
            int position = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            num.remove(position+1);
          }
          else{
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
              int tmp = Integer.parseInt(st.nextToken());
              num.add(tmp);
            }
          } 
        }
        
        System.out.print("#"+t+" ");
        for(int i=0; i<10; i++) System.out.print(num.get(i)+" ");
        System.out.println();
      }
  }
}