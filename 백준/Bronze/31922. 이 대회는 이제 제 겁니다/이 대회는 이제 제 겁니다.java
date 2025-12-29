import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int P = sc.nextInt();
        int C = sc.nextInt();

        int option1 = A + C;
        
        int option2 = P;

        int maxPrize = Math.max(option1, option2);
        
        System.out.println(maxPrize);

        sc.close();
    }
}