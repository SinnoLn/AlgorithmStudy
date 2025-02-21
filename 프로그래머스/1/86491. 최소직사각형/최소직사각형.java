import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int tmp = 0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            } 
        }
        
        int maxW = 0;
        int maxH = 0;
        for(int i=0 ;i<sizes.length; i++){
            maxH = Math.max(sizes[i][1], maxH);
            maxW = Math.max(sizes[i][0], maxW);
        }
        return maxH*maxW;
    }
}