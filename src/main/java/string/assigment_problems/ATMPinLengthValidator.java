
package string.assigment_problems;

import java.util.Scanner;

public class ATMPinLengthValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ATM PIN: ");
        String pin = sc.nextLine();

        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else if (!pin.matches("\\d{4}")) {
            System.out.println("Invalid PIN — must contain only digits.");
        } else {
            System.out.println("PIN length OK.");
        }

        sc.close();
    }
}
