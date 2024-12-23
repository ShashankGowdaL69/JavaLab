import java.util.Scanner;

class Account {
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String customerName, String accountNumber, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited. Updated balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

class SavAcct extends Account {
    SavAcct(String customerName, String accountNumber) {
        super(customerName, accountNumber, "Savings");
    }

    void computeAndDepositInterest(double rate, int years) {
        double interest = balance * Math.pow(1 + rate / 100, years) - balance;
        deposit(interest);
        System.out.println("Interest deposited. Updated balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn. Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 500;
    private static final double PENALTY = 50;

    CurAcct(String customerName, String accountNumber) {
        super(customerName, accountNumber, "Current");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn. Updated balance: " + balance);
            if (balance < MIN_BALANCE) {
                balance -= PENALTY;
                System.out.println("Minimum balance not maintained. Penalty imposed. Updated balance: " + balance);
            }
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class javalab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavAcct savings = new SavAcct("Alice", "SAV123");
        CurAcct current = new CurAcct("Bob", "CUR456");

        while (true) {
            System.out.println("\nChoose Account Type: 1. Savings 2. Current 3. Exit");
            int accountChoice = sc.nextInt();
            if (accountChoice == 3) break;

            Account selectedAccount = (accountChoice == 1) ? savings : current;
            System.out.println("Choose Operation: 1. Deposit 2. Withdraw 3. Display Balance");
            int operation = sc.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    selectedAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (selectedAccount instanceof SavAcct) {
                        ((SavAcct) selectedAccount).withdraw(withdrawAmount);
                    } else {
                        ((CurAcct) selectedAccount).withdraw(withdrawAmount);
                    }
                    break;
                case 3:
                    selectedAccount.displayBalance();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
