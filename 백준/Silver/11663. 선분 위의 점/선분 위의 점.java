import java.util.*;
import java.io.*;

class Main {
    public static int[] spot;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        spot = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) spot[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(spot);
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end  = Integer.parseInt(st.nextToken());
            
            int startIndex = FindStart(start, n);
            int endIndex = FindEnd(end, n);

            System.out.println(endIndex - startIndex);
        }
    }
    public static int FindStart(int target, int n){
        int left = 0, right = n;
        while(left < right){
            int mid = (left+right)/2;
            if(spot[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    public static int FindEnd(int target, int n){
        int left = 0, right = n;
        while(left < right){
            int mid = (left+right)/2;
            if(spot[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}