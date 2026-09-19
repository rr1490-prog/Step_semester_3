import java.util.Scanner;

public class ReverseCustomerName {

    static String reverseName(String name) {
        String reversed = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reversed = reversed + name.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        String reversedName = reverseName(name);

        System.out.println("Reversed customer name: " + reversedName);

        sc.close();
    }
}
