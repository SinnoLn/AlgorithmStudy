import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] diff = new int[n-1]; //간격의 크기는 n-1이니까
        st = new StringTokenizer(br.readLine());
        int prevNum = Integer.parseInt(st.nextToken());
        for(int i=0; i<n-1; i++){
            int currNum = Integer.parseInt(st.nextToken());
            diff[i] = currNum - prevNum; 
            prevNum = currNum;
        }

        int ans = 0;
        Arrays.sort(diff);
        //뒤부터 k-1개는 skip하고 나머지 차이 계산
        for(int i=diff.length-1-(k-1); i>-1; i--){
            ans+=diff[i];
        }
        System.out.println(ans);
    }
}