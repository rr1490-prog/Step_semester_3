
package polymorphism.assigment_problems;

import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;

                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;

                default:
                    employee = new Intern(name, salary);
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}

