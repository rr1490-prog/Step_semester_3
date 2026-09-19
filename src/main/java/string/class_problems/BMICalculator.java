import java.util.Scanner;

public class BMICalculator {

    static String getCategory(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of team members: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            sc.nextLine();

            System.out.println("\nMember " + i);

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter weight (kg): ");
            double weight = sc.nextDouble();

            System.out.print("Enter height (m): ");
            double height = sc.nextDouble();

            double bmi = weight / (height * height);

            System.out.printf("%s's BMI = %.2f%n", name, bmi);
            System.out.println("Category: " + getCategory(bmi));
        }

        sc.close();
    }
}
