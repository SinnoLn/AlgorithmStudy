import java.util.*;
import java.io.*;

//2억
//n개의 나무
//n일동안 하루 한 나무
//나무의 처음길이, 하루에 자라는 길이
//그럼 
class Main {
    static class Tree{
        int h, a;
        public Tree(int h, int a){
            this.h = h;
            this.a = a;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        Tree[] trees = new Tree[n];
        
        for(int i=0; i<n; i++){
            int h = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st2.nextToken());

            trees[i] = new Tree(h,a);
        }
        //성장률이 작은 순으로 정렬 O(nlogn)
        Arrays.sort(trees, (a,b)-> a.a-b.a);

        //총 n번의 나무자르기
        long sum = 0;
        for(int i=0; i<n; i++){
            sum+= trees[i].h + trees[i].a*(i);
        }
        System.out.println(sum);
    }
}