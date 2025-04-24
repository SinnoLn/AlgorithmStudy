import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t<=10; t++){
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] building = new int[n];
        for(int i=0; i<n; i++) building[i] = Integer.parseInt(st.nextToken());
        
        //맨왼쪽 2칸 맨오른쪽 2칸 건물 안지어짐
        //2번부터 n-2까지 확인? 맞나
        //두칸이상 떨어져있는지도 확인해야함
        //왼쪽을 더하고 오른쪽을 빼서 그걸 답에 더해야겠군
        
        int countL = 0;
        int countR = 0;
        int ans = 0;
        for(int i=2; i<n-2; i++){
          countL = Math.min(building[i]-building[i-1], building[i]-building[i-2]);
          countR = Math.min(building[i]-building[i+1], building[i]-building[i+2]);
          
          if(countL<0) countL = 0;
          if(countR<0) countR = 0;
          ans += Math.min(countL, countR);
        }
        System.out.println("#"+t + " "+ ans);
      }
  }
}