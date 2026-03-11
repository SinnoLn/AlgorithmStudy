import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int stage = 0;
      
      while(true){
         stage++;
         
         int n = Integer.parseInt(br.readLine());
         if(n == 0) return;
         String[] names = new String[n];
         List<int[]> ans = new ArrayList<>();
        
         for(int i=0; i<n; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           String name = st.nextToken();
           names[i] = name;
          
           for(int j=0; j<n-1; j++){
             char c = st.nextToken().charAt(0);
             if(c == 'P') continue;
            
             ans.add(new int[]{i,j});
           }
          }
          
           System.out.println("Group "+stage);
           if(ans.size() == 0){
            System.out.println("Nobody was nasty");
            System.out.println();
            continue; // stage 무시 주의
           }
          
           for(int[] a : ans){
             int pos = (a[0] - a[1]+n-1)%n; 
             System.out.println(names[pos] +" was nasty about "+ names[a[0]]);
           }
           System.out.println();
      }
    }
}