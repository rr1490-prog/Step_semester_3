
package polymorphism.assigment_problems;

import java.util.Scanner;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;

                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;

                default:
                    plan = new PremiumPlan(name, startDate);
            }

            LocalDate renewalDate = plan.calculateRenewalDate();

            System.out.printf("%s: %s%n", name, renewalDate);
        }

        sc.close();
    }
}
