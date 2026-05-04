import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            
            if(stack.isEmpty()) stack.add(i);
            else {
                while(!stack.isEmpty()&&numbers[stack.peek()]<num){
                    int index = stack.pop();
                    answer[index] = num;
                }
                stack.add(i);
            }
        } 
        return answer;
    }
}