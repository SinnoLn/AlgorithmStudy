import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int cookTime = sc.nextInt();

        hour+=cookTime/60;
        minute+=cookTime%60;

        if(minute >= 60){
            hour++;
            minute-=60;
        }

        hour = (hour%24);

        System.out.println(hour + " " + minute);
        
        sc.close();
    }
}