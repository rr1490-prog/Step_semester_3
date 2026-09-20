
package string.class_problems;

import java.util.Scanner;

public class FileExtensionValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String fileName = sc.nextLine().trim();

        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {

            String extension = fileName.substring(dotIndex + 1).toLowerCase();

            if (extension.equals("java")
                    || extension.equals("c")
                    || extension.equals("cpp")
                    || extension.equals("py")) {

                System.out.println("Valid programming file.");
                System.out.println("Extension: " + extension);

            } else {
                System.out.println("Unsupported file extension.");
            }

        } else {
            System.out.println("Invalid file name or missing extension.");
        }

        sc.close();
    }
}
