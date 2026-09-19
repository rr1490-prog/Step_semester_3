import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }

        boolean duplicateFound = false;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (seats[i] == seats[j]) {
                    System.out.println("Duplicate seat number found: " + seats[i]);
                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No duplicate seat numbers found.");
        }

        sc.close();
    }
}
