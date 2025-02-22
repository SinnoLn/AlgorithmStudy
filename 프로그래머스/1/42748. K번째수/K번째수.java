import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        for(int i=0; i<commands.length; i++){
            int tmp[] = new int[commands[i][1]-commands[i][0]+1];
            tmp = array.subString(commands[i][0]-1, commands[i][1]);
        }
        return answer;
    }
}