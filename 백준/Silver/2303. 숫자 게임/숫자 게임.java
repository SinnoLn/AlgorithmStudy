import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //아무거나 3장 선택 일의자리가 가장 크게
      //최대 1000명
      //각 5개의 정수
      //10번*1000번 완탐가능
      
      int num = Integer.parseInt(br.readLine());
      List<List<Integer>> list = new ArrayList<>();
      int[] maxSum = new int[num];
      
      for(int i=0; i<num; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(new ArrayList<>());
        
        for(int j=0; j<5; j++){
          int n = Integer.parseInt(st.nextToken());
          list.get(i).add(n);
        }
      }
      
      //완전탐색 시작
      //4중for문은 좀 끔찍하지만...
      //최대 1000*10 -> 10000번이라 ㄱㅊ
      for(int p=0; p<num; p++){
        int sum = 0;
        for(int i=0; i<3; i++){
          for(int j=i+1; j<4; j++){
            for(int k=j+1; k<5; k++){
              sum =list.get(p).get(i) + list.get(p).get(j) + list.get(p).get(k);
              sum%=10;
              maxSum[p] = Math.max(maxSum[p],sum);
            }
          }
        }
      }
      
      int ans = -1;
      int totalSum = -1;
      for(int i=0; i<num; i++){
        if(totalSum<maxSum[i]){
          ans = i;
          totalSum = maxSum[i]; 
        }
        else if(totalSum == maxSum[i]){
          ans = Math.max(ans, i);
        }
      }
      
      System.out.println(ans+1);
  }
}