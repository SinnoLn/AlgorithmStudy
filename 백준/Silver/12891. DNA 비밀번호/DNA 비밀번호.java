import java.util.*;
import java.io.*;

//모든 문자열이 ACGT
//A=0 C=1 G=2 T=3
//만들 수 있는 모든 비밀번호 수
public class Main { 
    static int len, passLen;
    static int[] words;
    static int[] limit = new int[4];
    static int[] cnt = new int[4];
    static int result;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      len = Integer.parseInt(st.nextToken());
      passLen = Integer.parseInt(st.nextToken());
      words = new int[len];
      
      String line = br.readLine();
      for(int i=0; i<len; i++){
        if(line.charAt(i) == 'A') words[i] = 0;
        else if(line.charAt(i) == 'C') words[i] = 1;
        else if(line.charAt(i) == 'G') words[i] = 2;
        else words[i] = 3;
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<4; i++){
        limit[i] = Integer.parseInt(st.nextToken());
      }
      
      for(int i=0; i<passLen; i++){
        cnt[words[i]]++;
      }
      
      //슬라이딩 윈도우 시작
      slidingWindow();
      System.out.println(result);
  }
  
  static void slidingWindow(){
    if(cnt[0] >= limit[0] && cnt[1] >= limit[1] && cnt[2] >= limit[2] && cnt[3] >= limit[3])
      result ++;
      
      for(int i=passLen; i<len; i++){
        cnt[words[i-passLen]]--;
        cnt[words[i]]++;
        
        if(cnt[0] >= limit[0] && cnt[1] >= limit[1] && cnt[2] >= limit[2] && cnt[3] >= limit[3])
          result ++;
      }
  }
}