import java.util.Scanner;

class Account {
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    public Account(String customerName, String accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". Updated Balance: " + balance);
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavAcct extends Account {
    public SavAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

    public void computeAndDepositInterest(double rate, int years) {
        double interest = balance * Math.pow(1 + rate / 100, years) - balance;
        balance += interest;
        System.out.println("Interest of " + interest + " added. Updated Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated Balance: " + balance);
        }
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000;
    private static final double PENALTY = 100;

    public CurAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            if (balance < MIN_BALANCE) {
                balance -= PENALTY;
                System.out.println("Minimum balance not maintained. Penalty of " + PENALTY + " imposed.");
            }
            System.out.println("Withdrawn: " + amount + ". Updated Balance: " + balance);
        }
    }
}

public class javalab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter account type (Savings/Current): ");
        String type = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        if (type.equalsIgnoreCase("Savings")) {
            SavAcct savings = new SavAcct(name, accNum, balance);
            savings.deposit(500);
            savings.computeAndDepositInterest(5, 2);
            savings.withdraw(200);
            savings.displayBalance();
        } else if (type.equalsIgnoreCase("Current")) {
            CurAcct current = new CurAcct(name, accNum, balance);
            current.deposit(1000);
            current.withdraw(2000);
            current.displayBalance();
        } else {
            System.out.println("Invalid account type.");
        }
    }
}
