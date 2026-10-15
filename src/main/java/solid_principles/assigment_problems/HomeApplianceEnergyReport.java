
package solid_principles.assigment_problems;

import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    protected double power;

    Appliance(double hours, double power) {
        this.hours = hours;
        this.power = power;
    }

    double calculateUnits() {
        return (power * hours) / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * 8.0;
    }
}

interface SaverMode {
    double SAVING_FACTOR = 0.75;
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours, 150);
    }
}

class AC extends Appliance implements SaverMode {
    private boolean saver;

    AC(double hours, boolean saver) {
        super(hours, 1500);
        this.saver = saver;
    }

    @Override
    double calculateUnits() {
        double units = super.calculateUnits();
        return saver ? units * SAVING_FACTOR : units;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours, 100);
    }
}

class Washer extends Appliance implements SaverMode {
    private boolean saver;

    Washer(double hours, boolean saver) {
        super(hours, 500);
        this.saver = saver;
    }

    @Override
    double calculateUnits() {
        double units = super.calculateUnits();
        return saver ? units * SAVING_FACTOR : units;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    if (saver) {
                        System.out.println(
                            "FRIDGE: saver mode not supported"
                        );
                        continue;
                    }
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AC(hours, saver);
                    break;

                case "TV":
                    if (saver) {
                        System.out.println(
                            "TV: saver mode not supported"
                        );
                        continue;
                    }
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new Washer(hours, saver);
                    break;

                default:
                    System.out.println("Invalid appliance type");
                    continue;
            }

            double units = appliance.calculateUnits();
            double cost = appliance.calculateCost();

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}
