import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=0; t<test; t++){
        Map<String,Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
        
          String a = st.nextToken();
          String b = st.nextToken();
          
          if(map.containsKey(b)) map.put(b,map.get(b)+1);
          else map.put(b,1); 
        }
        int ans = 1;
        for(int val : map.values()){
          ans*= val+1; //안입는 경우
        }
        
        ans-=1; //전부 안입는 경우
        System.out.println(ans);
      }
  }
}