
package polymorphism.assigment_problems;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                default:
                    vehicle = new Truck(hours);
            }

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

