
package string.class_problems;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a 10-digit phone number: ");
        String phone = sc.nextLine().trim();

        if (phone.matches("\\d{10}")) {

            String masked = "******" + phone.substring(6);

            System.out.println("Masked phone number: " + masked);

        } else {
            System.out.println("Invalid phone number. Must contain 10 digits.");
        }

        sc.close();
    }
}
