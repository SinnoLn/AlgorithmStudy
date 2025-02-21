import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int h = 0;
        int w = 0;
        
        for(int i=1; i<15000; i++){
            if(total%i == 0){
                w = i;
                h = total/i;
                
                if((h*2+w*2-4) == brown){
                    answer[0] = h;
                    answer[1] = w;
                    break;
                }
            }
        }
        return answer;
    }
}