import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //이전 ~ 정각 대회
      //끝난 정각 ~ 스트리밍 끝날때까지
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      String[] s = (st.nextToken()).split(":");
      String[] e = (st.nextToken()).split(":");
      String[] q = (st.nextToken()).split(":");
      
      int sti = 60*Integer.parseInt(s[0])+Integer.parseInt(s[1]);
      int eti = 60*Integer.parseInt(e[0])+Integer.parseInt(e[1]);
      int qti = 60*Integer.parseInt(q[0])+Integer.parseInt(q[1]);
      
      //최대 10만 줄 이하
      Set<String> enter = new HashSet<>();
      Set<String> ans = new HashSet<>();
      
      String line;
      while((line = br.readLine()) != null){
        String[] input = line.split(" ");
        
        String[] sTime = input[0].split(":");
        String name = input[1];
        
        int time = 60*Integer.parseInt(sTime[0])+Integer.parseInt(sTime[1]);
        
        if(time<=sti){
          enter.add(name);
        }
        //중복채팅
        else if(eti<=time && time<=qti){
          if(enter.contains(name)){
            ans.add(name);
          }
        }
      }
      
      System.out.println(ans.size());
    }
}