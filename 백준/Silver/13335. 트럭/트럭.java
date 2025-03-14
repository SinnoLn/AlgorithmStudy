import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] truck = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }

        //무게, 트럭이 머무른 시간을 저장
        Queue<int[]> bridge = new LinkedList<>();
        int time = 0;
        int currWeight = 0;
        int index = 0;
        
        while(true){
            time++;
            
            //트럭이 다 지나갔을 경우
            if(!bridge.isEmpty() && bridge.peek()[1] == w){
                currWeight -= bridge.poll()[0];
            }

            //다리에 트럭을 올릴 수 있는지 확인
            if(index < n && (currWeight + truck[index]) <= l && bridge.size() < w){
                bridge.add(new int[]{truck[index], 0});
                currWeight += truck[index];
                index++;
            }

            //트럭을 한칸씩 앞으로 이동
            for(int[] b : bridge) b[1]++;

            //다리에 아무것도 없고, 모든 트럭을 다 보냈을 경우
            if(bridge.isEmpty() && index >= n) break;
        }
        System.out.println(time);
    }
}