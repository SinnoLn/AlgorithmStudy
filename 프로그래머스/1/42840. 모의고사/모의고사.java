import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int c[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cor = new int[3];
        for(int i=0; i<answers.length; i++){
            if(a[i%5] == answers[i]) cor[0]++; 
            if(b[i%8] == answers[i]) cor[1]++;
            if(c[i%10] == answers[i]) cor[2]++;
        }
        
        int maxScore = Math.max(cor[0], Math.max(cor[1], cor[2]));
        List<Integer> winners = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            if(cor[i]==maxScore){
                winners.add(i+1);
            }
        }
        return winners.stream().mapToInt(i->i).toArray();
    }
}