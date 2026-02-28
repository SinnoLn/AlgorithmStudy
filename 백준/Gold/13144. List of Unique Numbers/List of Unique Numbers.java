import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] arr = new int[n];
      Map<Integer,Integer> map = new HashMap<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for(int i=0; i<n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        if(map.containsKey(arr[i])) continue;
        map.put(arr[i], 0);
      }
      
      int l = 0;
      int r = 0;
      long ans = 1L;
      map.put(arr[r], map.get(arr[r])+1);
      
      //r을 기준으로 체크
      while(l<=r) {
        while(map.get(arr[r]) == 2){
          map.put(arr[l], map.get(arr[l])-1);
          l++;
          if(map.get(arr[r]) != 2) ans += r-l+1;
        }
        
        r++;
        if(r == n) break;
        map.put(arr[r], map.get(arr[r])+1);
        if(map.get(arr[r]) != 2) ans += r-l+1;
      }
      
      System.out.println(ans);
    }
}