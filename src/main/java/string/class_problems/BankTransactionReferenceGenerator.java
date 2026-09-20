
package string.class_problems;

import java.util.Scanner;

public class BankTransactionReferenceGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String reference = sc.nextLine().trim();

        if (reference.matches("[A-Za-z]{3}\\d{11}")) {

            String bankCode = reference.substring(0, 3).toUpperCase();
            String date = reference.substring(3, 9);
            String sequence = reference.substring(9);

            System.out.println("Valid transaction reference.");
            System.out.println("Bank Code: " + bankCode);
            System.out.println("Date (DDMMYY): " + date);
            System.out.println("Sequence Number: " + sequence);

        } else {
            System.out.println("Invalid transaction reference.");
            System.out.println("Format: 3 letters followed by 11 digits.");
        }

        sc.close();
    }
}
