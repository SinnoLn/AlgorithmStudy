import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for(int test = 1; test<=t; test++){
        int[] num = new int[10];
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        for(int i=1; i<9; i++) sum+=num[i];
        sum/=8;
        
        System.out.println("#"+test+" "+Math.round(sum));
      }
    }
}