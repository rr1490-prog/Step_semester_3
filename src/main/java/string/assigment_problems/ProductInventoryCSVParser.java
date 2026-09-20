
package string.assigment_problems;

import java.util.Scanner;

public class ProductInventoryCSVParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product record (name,quantity,price): ");
        String record = sc.nextLine();

        String[] data = record.split(",");

        if (data.length == 3) {

            String productName = data[0].trim();
            String quantity = data[1].trim();
            String price = data[2].trim();

            System.out.println("Product Name: " + productName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price: " + price);

        } else {
            System.out.println("Invalid product record. Expected 3 fields.");
        }

        sc.close();
    }
}
