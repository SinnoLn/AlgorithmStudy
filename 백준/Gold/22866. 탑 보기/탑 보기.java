import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] counts = new int[n];
        int[] nearest = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            counts[i] += stack.size();
            if(!stack.isEmpty()) {
                nearest[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            counts[i] += stack.size();
            if(!stack.isEmpty()) {
                if(nearest[i] == 0) {
                    nearest[i] = stack.peek() + 1;
                } else {
                    int leftDist = i - (nearest[i] - 1);
                    int rightDist = stack.peek() - i;
                    
                    if(rightDist < leftDist) {
                        nearest[i] = stack.peek() + 1;
                    } else if (rightDist == leftDist) {
                        nearest[i] = Math.min(nearest[i], stack.peek() + 1);
                    }
                }
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(counts[i]).append(" ");
            if (counts[i] > 0) {
                sb.append(nearest[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}