import java.util.*;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        int answer = 0;
        
        dfs("", arr, visited);
        
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        
        System.out.println(answer);
        
        return answer;
    }
    public static void dfs(String current, char[] arr, boolean[] visited){
        if(!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(current+arr[i], arr, visited);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num){
        if(num == 0) return false;
        if(num == 1) return false;
        if(num == 2) return true;
        
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}