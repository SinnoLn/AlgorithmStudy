import java.util.*;
import java.io.*;

public class Main {
    static int n,k,cnt;
    static List<Integer> diff = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        if(a>=b) cnt++;
        else diff.add(b-a);
      }
      
      int ans = findPrice();
      System.out.println(ans);
    }
    
    static int findPrice(){
      if(cnt>=k) return 0;
      
      Collections.sort(diff);
      int findCnt = k-cnt;
      
      return diff.get(findCnt-1);
    }
}