import java.util.*;
import java.io.*;

public class Main{
    static class Candidate {
      int id;
      int votes;
      int timestamp;
     
      public Candidate(int id, int votes, int timestamp){
        this.id = id;
        this.votes = votes;
        this.timestamp = timestamp;
      } 
    };
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int v = Integer.parseInt(br.readLine());
      
      List<Candidate> list = new ArrayList<>();
      Map<Integer, Candidate> map = new HashMap<>();
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for(int i=0; i<v; i++){
        int currVoted = Integer.parseInt(st.nextToken());
        if(map.containsKey(currVoted)){
          map.get(currVoted).votes++;
        }
        else{
          //게시되어있지 않다면
          Candidate newCandidate = new Candidate(currVoted, 1, i);
          //비어있는 틀이 없다면
          if(list.size() == n){
            //가장 덜 추천되고, 가장 오래된 사진 삭제
            //이때 정렬이 아닌 조건에 맞는 최소값을 찾음
            //왜? 전부 정렬할 필요 없으니까까
            Candidate toRemove = Collections.min(
              list,
              Comparator
                .comparingInt((Candidate c) -> c.votes)
                .thenComparingInt(c -> c.timestamp));
              list.remove(toRemove);
              map.remove(toRemove.id);
              
              list.add(newCandidate);
              map.put(currVoted, newCandidate);
          }
          //아직 비어있다면
          //새 후보 추가
          else{
            list.add(newCandidate);
            map.put(currVoted, newCandidate);
          }
        }
        // for(Candidate c : list){
        //   System.out.print(c.id + " ");
        // }
        // System.out.println();
      }
      list.sort(Comparator.comparingInt(c -> c.id));
      for(int i=0; i<list.size(); i++){
        System.out.print(list.get(i).id + " ");
      }
      
  }
}