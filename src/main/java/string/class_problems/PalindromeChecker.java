import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Using StringBuilder
    static boolean checkUsingStringBuilder(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Approach 2: Using a loop
    static boolean checkUsingLoop(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        return str.equals(reversed);
    }

    // Approach 3: Using two pointers
    static boolean checkUsingTwoPointers(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println();

        System.out.println("Approach 1 - StringBuilder: "
                + checkUsingStringBuilder(str));

        System.out.println("Approach 2 - Loop: "
                + checkUsingLoop(str));

        System.out.println("Approach 3 - Two Pointers: "
                + checkUsingTwoPointers(str));

        sc.close();
    }
}