import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      List<Integer> list = new ArrayList<>();

      //먼저 소수의 합을 구하기
      //그리고 그 배열로 투포인터 돌리기
      
      //1. 소수를 구한다.
      boolean[] isNotPrime = new boolean[n+1];
      isNotPrime[0] = isNotPrime[1] = true;
      for(int i=2; i<=n/2; i++){
        if(isNotPrime[i]) continue;
        for(int j=i+i; j<=n; j+=i){
          isNotPrime[j] = true;
        }
      }
      //소수를 입력받는다
      for(int i=0; i<=n; i++){
        if(!isNotPrime[i]) list.add(i);
      }
      
      //소수가 하나도 없다면
      if(list.isEmpty()){
        System.out.println(0);
        return;
      }
      
      int l = 0;
      int r = 0;
      int sum = list.get(0);
      int ans = 0;
      
      while(l<=r) {
        if(sum>=n) {
          if(sum == n) ans++;
          sum-=list.get(l);
          l++;
        }
        else {
          r++;
          if(r == list.size()) break;
          sum+=list.get(r);
        }
      }
      
      System.out.println(ans);
    }
}