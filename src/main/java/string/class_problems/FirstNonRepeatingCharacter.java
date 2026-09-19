import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    static char findFirstNonRepeating(String str) {

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {

                if (current == str.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                return current;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char result = findFirstNonRepeating(str);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}
