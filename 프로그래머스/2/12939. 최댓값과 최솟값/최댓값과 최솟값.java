import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            int tmp = Integer.parseInt(nums[i]);
            max = Math.max(max,tmp);
            min = Math.min(min,tmp);
        }
        answer = min + " " + max;
        return answer;
    }
}