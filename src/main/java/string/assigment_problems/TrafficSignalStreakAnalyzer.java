import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of signals: ");
        int n = sc.nextInt();

        String[] signals = new String[n];

        System.out.println("Enter traffic signals:");

        for (int i = 0; i < n; i++) {
            signals[i] = sc.next();
        }

        String longestSignal = signals[0];
        int longestStreak = 1;

        String currentSignal = signals[0];
        int currentStreak = 1;

        for (int i = 1; i < n; i++) {

            if (signals[i].equals(currentSignal)) {
                currentStreak++;
            } else {
                currentSignal = signals[i];
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestSignal = currentSignal;
            }
        }

        System.out.println("Longest Signal Streak: " + longestSignal);
        System.out.println("Streak Length: " + longestStreak);

        sc.close();
    }
}
