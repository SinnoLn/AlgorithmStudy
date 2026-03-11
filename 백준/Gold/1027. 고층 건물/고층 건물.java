import java.util.*;
import java.io.*;

public class Main {
  // 1.기울기를 “역수”로 비교하고 있지 않은지
  // 2.같은 높이를 무조건 continue 해도 되는지
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //가장 많은 고층 빌딩이 보이는 고층빌딩
      //최대 10억 높이
      //빌딩 1<=n<=50
      
      //두 선분의 교점
      //한 빌딩 기준 왼쪽 오른쪽 파악
      int n = Integer.parseInt(br.readLine());
      int[] building = new int[n];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        building[i] = Integer.parseInt(st.nextToken());
      }
      
      //최대 2500
      int ans = 0;
      for(int i=0; i<n; i++){
        //왼쪽 (-로 갈수록 높음)
        int buildingCnt = 0;
        //기울기 주의
        double maxLeftIncli = Double.POSITIVE_INFINITY;
        double maxRightIncli = Double.NEGATIVE_INFINITY;

        for(int j=i-1; j>-1; j--){
          
          double inclination = (building[j]-building[i])/(double)(j-i);
          
          if(maxLeftIncli>inclination){
            buildingCnt++;
            maxLeftIncli = inclination;
          }
        }
        
        //오른쪽
        for(int j=i+1; j<n; j++){
          
          double inclination = (building[j]-building[i])/(double)(j-i);
          if(maxRightIncli<inclination){
            buildingCnt++;
            maxRightIncli = inclination;
          }
        }
        
        ans = Math.max(ans, buildingCnt);
      }
      
      System.out.println(ans);
    }
}