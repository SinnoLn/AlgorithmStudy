import java.util.*;
import java.io.*;

public class Solution {
    static int[] endDay = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] startDate = new int[2];
        int[] endDate = new int[2];
        
        startDate[0] = Integer.parseInt(st.nextToken());
        startDate[1] = Integer.parseInt(st.nextToken());
        endDate[0] = Integer.parseInt(st.nextToken());
        endDate[1] = Integer.parseInt(st.nextToken());
        
        int ans = countDate(startDate, endDate);
        System.out.println("#"+t+" "+ans);
      }
  }
  static int countDate(int[] start, int[] end){
    int day = 0;
    for(int i=start[0]; i<end[0]; i++){
      day+=endDay[i];
    }
    
    //추가적 더하기
    day+=end[1] - start[1] +1;
    return day;
  }
}