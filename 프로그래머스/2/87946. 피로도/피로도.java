import java.util.*;

class Solution {
    public static int maxDungeons;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, visited, dungeons);
        return maxDungeons;
    }
    
    public static void dfs(int k, int count, boolean[] visited, int[][] dungeons){
        maxDungeons = Math.max(count, maxDungeons);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                dfs(k-dungeons[i][1], count+1, visited, dungeons);
                visited[i] = false;
            }
        }
    }
}