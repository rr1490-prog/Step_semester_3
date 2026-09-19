import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int[] inventory = new int[n];

        System.out.println("Enter inventory quantities:");

        for (int i = 0; i < n; i++) {
            inventory[i] = sc.nextInt();
        }

        int total = 0;

        for (int i = 0; i < n; i++) {
            total += inventory[i];
        }

        double average = (double) total / n;

        System.out.println("Total Inventory: " + total);
        System.out.printf("Average Inventory: %.2f%n", average);

        System.out.println("Inventory Status:");

        for (int i = 0; i < n; i++) {

            if (inventory[i] > average) {
                System.out.println(
                    "Product " + (i + 1) + ": Above Average"
                );
            } else if (inventory[i] < average) {
                System.out.println(
                    "Product " + (i + 1) + ": Below Average"
                );
            } else {
                System.out.println(
                    "Product " + (i + 1) + ": Balanced"
                );
            }
        }

        sc.close();
    }
}