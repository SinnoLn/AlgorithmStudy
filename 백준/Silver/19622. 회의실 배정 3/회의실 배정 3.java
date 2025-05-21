import java.util.*;
import java.io.*;

public class Main {
    static class Room {
        int startTime;
        int endTime;
        int people;

        public Room(int startTime, int endTime, int people) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.people = people;
        }
    }
    
    static Room[] rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(s, e, p);
        }

        Arrays.sort(rooms, (a,b)->{
          if(a.endTime == b.endTime) return a.startTime - b.startTime;
          return a.endTime - b.endTime;
        });

        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = rooms[i].endTime;
        }
        
        //i번째 방까지 고려했을때 최대 인원
        int[] dp = new int[n];
        dp[0] = rooms[0].people;

        for (int i = 1; i < n; i++) {
            int idx = binarySearch(i);
            
            //겹치는 회의가 없을때
            if (idx < 0) idx = -idx - 2;;  
            
            //가능한 회의가 있다면 
            if (idx >= 0) dp[i] = Math.max(dp[i - 1], dp[idx] + rooms[i].people);
            else dp[i] = Math.max(dp[i - 1], rooms[i].people); 
        }
        System.out.println(dp[n - 1]);
    }
    
    //마지막 시간과 겹치지 않는 마지막 회의
    static int binarySearch(int i){
      int left = 0;
      int right = i-1;
      int result = -1;
      
      while(left<=right){
        int mid = (left+right)/2;
        if(rooms[mid].endTime <= rooms[i].startTime){
          result = mid;
          left = mid+1;
        }
        else {
          right = mid -1;
        }
      }
      return result;
    }
}
