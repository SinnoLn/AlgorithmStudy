import java.util.*;
import java.io.*;

public class Main {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
      //가장 작은 시계수 구하기
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int[] num = new int[4];
      num[0] = Integer.parseInt(st.nextToken());
      num[1] = Integer.parseInt(st.nextToken());
      num[2] = Integer.parseInt(st.nextToken());
      num[3] = Integer.parseInt(st.nextToken());
      
      int a = num[0]*1000 + num[1]*100 + num[2]*10 + num[3];
      int b = num[3]*1000 + num[0]*100 + num[1]*10 + num[2];
      int c = num[2]*1000 + num[3]*100 + num[0]*10 + num[1];
      int d = num[1]*1000 + num[2]*100 + num[3]*10 + num[0];
      
      int minNum = Math.min(Math.min(Math.min(a,b),c),d);
      
      int ans = 0;
      //완전탐색
      //가지치기
      for(int i=1111; i<=minNum; i++){
        String s = Integer.toString(i);
        if(s.contains("0")) continue;
        if(set.contains(s)) continue; 
        //시계수 저장
        saveNum(s);
        ans++;
      }
      System.out.println(ans);
  }
  static void saveNum(String s){
    int[] num = new int[4];
    for(int i=0; i<4; i++){
      num[i] = s.charAt(i) - '0';
    }
    String a =""+num[0] + num[1] + num[2] + num[3];
    String b =""+num[3] + num[0] + num[1] + num[2];
    String c =""+num[2] + num[3] + num[0] + num[1];
    String d =""+num[1] + num[2] + num[3] + num[0];
    
    set.add(a);
    set.add(b);
    set.add(c);
    set.add(d);
  }
}