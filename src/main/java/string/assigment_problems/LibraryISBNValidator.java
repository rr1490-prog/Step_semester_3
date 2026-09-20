
package string.assigment_problems;

import java.util.Scanner;

public class LibraryISBNValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String isbn = sc.nextLine().trim().toUpperCase();

        if (isbn.length() != 13) {
            System.out.println("Invalid ISBN — must contain exactly 13 characters.");

        } else {

            String publisherCode = isbn.substring(0, 3);
            String remaining = isbn.substring(3);

            boolean validPublisher = publisherCode.matches("[A-Z]{3}");
            boolean validDigits = remaining.matches("\\d{10}");

            if (!validPublisher) {
                System.out.println("Invalid ISBN — first 3 characters must be letters.");

            } else if (!validDigits) {
                System.out.println("Invalid ISBN — remaining 10 characters must be digits.");

            } else {

                String year = isbn.substring(3, 7);
                String catalog = isbn.substring(7);

                System.out.println("[" + publisherCode + "] YEAR: "
                        + year + " | CATALOG: " + catalog);
            }
        }

        sc.close();
    }
}
