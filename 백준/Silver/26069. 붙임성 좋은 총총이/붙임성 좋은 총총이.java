import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      Set<String> set = new HashSet<>();
      set.add("ChongChong");
      int ans = 1; //총총이 포함
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        
        if(set.contains(a)){
          if(set.contains(b)) continue;
          ans++;
          set.add(b);
        }
        else if(set.contains(b)){
          if(set.contains(a)) continue;
          ans++;
          set.add(a);
        }
      }
      System.out.println(ans);
    }
}