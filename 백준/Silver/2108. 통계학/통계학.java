import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      //N은 홀수
      //최대 50만개
      
      int[] num = new int[8001];
      int OFFSET = 4000;
      long sum = 0L;
      int mid = (n/2)+1;
      
      int minNum = Integer.MAX_VALUE;
      int maxNum = Integer.MIN_VALUE;

      for(int i=0; i<n; i++){
        int input = Integer.parseInt(br.readLine());
        sum+=input;
        num[input+OFFSET]++;
        
        minNum = Math.min(minNum, input);
        maxNum = Math.max(maxNum, input);
      }
      
      int count = 0;
      int midNum = 0;
      for(int i = 0; i < 8001; i++){
          count += num[i];
          if(count >= mid){
              midNum = i - OFFSET;
              break;
          }
      }
      
      int maxFreq = 0;
      for(int i=0; i<8001; i++){
        maxFreq = Math.max(maxFreq, num[i]);
      }
      
      int modeNum = 0;
      int modeCount = 0;
      for(int i = 0; i < 8001; i++){
          if(num[i] == maxFreq){
              modeCount++;
              modeNum = i - OFFSET;
              if(modeCount == 2) break;
          }
      }
      
      System.out.println(Math.round((double)sum/n));
      System.out.println(midNum);
      System.out.println(modeNum);
      System.out.println(maxNum-minNum);
    }
}