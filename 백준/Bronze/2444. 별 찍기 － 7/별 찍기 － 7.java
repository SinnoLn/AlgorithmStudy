import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            int space = N - i;
            int star = 2 * i - 1;
            System.out.print(" ".repeat(space));
            System.out.println("*".repeat(star));
        }

        for(int i = N - 1; i >= 1; i--) {
            int space = N - i;
            int star = 2 * i - 1;
            System.out.print(" ".repeat(space));
            System.out.println("*".repeat(star));
        }
    }
}
