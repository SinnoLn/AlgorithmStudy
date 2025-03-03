import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] steppingStones = new int[n];
        for(int i=0; i<n; i++){
            steppingStones[i] = sc.nextInt();
        }
        int a = sc.nextInt()-1; //0-index 기준
        int b = sc.nextInt()-1; //0-index 기준
        
        boolean[] visited = new boolean[n];
        boolean isArrived = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,0});
        visited[a] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNum = curr[0]; // 현재 위치
            int jumps = curr[1]; //현재까지의 점프 횟수
            
            if(currNum == b){
                isArrived = true;
                System.out.println(jumps);
                break;
            }
            
            int step = steppingStones[currNum];
            
            for(int next=currNum+step; next<n; next+=step){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[] {next,jumps+1});
                }
            }
            
            for(int next=currNum-step; next>-1; next-=step){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[] {next,jumps+1});
                }
            }
        }
        
        if(!isArrived) System.out.println(-1);
    }
}