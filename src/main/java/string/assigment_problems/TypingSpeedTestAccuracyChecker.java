import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        int correctCharacters = 0;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                correctCharacters++;
            }
        }

        int totalCharacters = original.length();

        double accuracy = (correctCharacters * 100.0) / totalCharacters;

        System.out.println();
        System.out.println("Correct Characters: " + correctCharacters);
        System.out.println("Total Characters: " + totalCharacters);
        System.out.printf("Typing Accuracy: %.2f%%%n", accuracy);

        sc.close();
    }
}
