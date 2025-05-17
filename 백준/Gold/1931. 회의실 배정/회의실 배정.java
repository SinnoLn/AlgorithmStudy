import java.util.*;
import java.io.*;

//최대로 회의실 많이 사용해야함
public class Main {
   static class Meeting{
     int startTime;
     int endTime;
     
     public Meeting(int startTime, int endTime){
       this.startTime = startTime;
       this.endTime = endTime;
     }
   };
   
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      Meeting[] meetingList = new Meeting[n];
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        meetingList[i] = new Meeting(s,e);
      }
      
      //그냥 끝나는 시간이 짧은 순으로 정렬
      Arrays.sort(meetingList, (a,b) -> {
        if(a.endTime == b.endTime) return a.startTime - b.startTime;
        return a.endTime - b.endTime;
      });
      
      int cnt = 1;
      int nextStart = meetingList[0].endTime;
      
      for(int i=1; i<n; i++){
        if(nextStart <= meetingList[i].startTime){
          cnt++;
          nextStart = meetingList[i].endTime;
        }
      }
      
      System.out.println(cnt);
  }
}