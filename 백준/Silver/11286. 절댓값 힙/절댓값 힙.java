import java.util.*;
import java.io.*;

//0<=n<=100000
//0이면 절댓값이 가장 작은 값 출력, 그 값 배열에서 제거
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      
      //minHeap 양수 (1,2,3,3,4,5---)
      //maxHeap 음수 (-1,-3,-4,-5,-5,-6---)
      for(int i=0; i<n; i++){
          int num = Integer.parseInt(br.readLine());
          
          if(num!=0){
            if(num >0) minHeap.add(num);
            else maxHeap.add(num);
          }
          else{
            if(minHeap.isEmpty() && maxHeap.isEmpty()){
              System.out.println(0);
            }
            else{
               if(minHeap.isEmpty()) System.out.println(maxHeap.poll());
               else if(maxHeap.isEmpty()) System.out.println(minHeap.poll());
               else{
                 if(Math.abs(maxHeap.peek())==Math.abs(minHeap.peek())){
                    System.out.println(maxHeap.poll());
                  }
                  else if(Math.abs(maxHeap.peek())<Math.abs(minHeap.peek())){
                    System.out.println(maxHeap.poll());
                  }
                  else{
                    System.out.println(minHeap.poll());
                  }
               }
               
            }
          }
        }
      }
}