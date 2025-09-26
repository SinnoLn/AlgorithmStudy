import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      //작업량 병렬버전 개발 시간 + 프로그램 실행시간
      for(int t=0; t<test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        int pTime = d+n*p;
        int sTime = n*s;

        if(sTime == pTime) System.out.println("does not matter");
        else if(sTime>pTime) System.out.println("parallelize");
        else System.out.println("do not parallelize");
      }
  }
}