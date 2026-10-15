
package solid_principles.assigment_problems;

import java.util.Scanner;

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        return Math.max(km * getRate(), 100.0);
    }
}

interface NightService {
    double NIGHT_SURCHARGE = 0.20;
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 14.0;
    }

    @Override
    double calculateFare() {
        return super.calculateFare();
    }

    double calculateNightFare() {
        return calculateFare() * (1 + NIGHT_SURCHARGE);
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 18.0;
    }

    @Override
    double calculateFare() {
        return super.calculateFare();
    }

    double calculateNightFare() {
        return calculateFare() * (1 + NIGHT_SURCHARGE);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;
            boolean nightAvailable = true;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    nightAvailable = false;
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
                default:
                    System.out.println("Invalid cab type");
                    continue;
            }

            if (time.equals("NIGHT") && !nightAvailable) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare *= 1.20;
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

