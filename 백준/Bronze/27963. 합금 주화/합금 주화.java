import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double d1 = sc.nextDouble();
        double d2 = sc.nextDouble();
        double x = sc.nextDouble();

        double dHigh = Math.max(d1, d2);
        double dLow = Math.min(d1, d2);

        double mHigh = x;
        double mLow = 100 - x;

        double vHigh = mHigh / dHigh;
        double vLow = mLow / dLow;

        double totalDensity = 100 / (vHigh + vLow);

        System.out.println(totalDensity);
        
        sc.close();
    }
}