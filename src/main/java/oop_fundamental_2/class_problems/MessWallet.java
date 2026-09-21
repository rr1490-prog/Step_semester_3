
package oop_fundamental_2.class_problems;

public class MessWallet {

    private double balance;

    MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Invalid opening balance. Setting balance to 0.");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: invalid amount");
        } else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction rejected: invalid amount");
        } else if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Balance after deduction: " + balance);
        }
    }

    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(800);

        System.out.println("Final balance: " + wallet.getBalance());
    }
}
