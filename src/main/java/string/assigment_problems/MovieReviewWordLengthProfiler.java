import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        String[] words = review.trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {

            int length = word.length();

            if (length <= 4) {
                shortWords++;
            } else if (length <= 7) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short words (1-4 characters): " + shortWords);
        System.out.println("Medium words (5-7 characters): " + mediumWords);
        System.out.println("Long words (8+ characters): " + longWords);

        sc.close();
    }
}