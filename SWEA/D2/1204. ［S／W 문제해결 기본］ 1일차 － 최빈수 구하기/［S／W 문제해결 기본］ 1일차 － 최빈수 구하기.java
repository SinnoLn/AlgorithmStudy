import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for(int i=0; i<t; i++){
        int test = Integer.parseInt(br.readLine());
        int[] num = new int[101];
        
        int maxNum = -1;
        int maxFre = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int s=0; s<1000; s++){
          int grade = Integer.parseInt(st.nextToken());
          
          num[grade]++;
          if(maxFre == num[grade]){
            if(maxNum < grade) maxNum = grade;
          }
          else if(maxFre < num[grade]){
            maxFre = num[grade];
            maxNum = grade;
          }
        }
        System.out.println("#"+test+" "+maxNum);
      }
  }
}