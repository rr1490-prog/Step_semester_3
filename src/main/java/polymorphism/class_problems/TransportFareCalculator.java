
package polymorphism.class_problems;

import java.util.Scanner;

abstract class Transport {

    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        double fare = 2 + (0.10 * distance);
        return Math.min(fare, 10);
    }

    @Override
    String getType() {
        return "BUS";
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    String getType() {
        return "METRO";
    }
}

public class TransportFareCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            switch (type) {

                case "BUS":
                    transport = new Bus(distance);
                    break;

                case "TRAIN":
                    transport = new Train(distance);
                    break;

                case "METRO":
                    double factor = sc.nextDouble();
                    transport = new Metro(distance, factor);
                    break;

                default:
                    continue;
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n",
                    transport.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
