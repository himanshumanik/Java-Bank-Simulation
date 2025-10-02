import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor to initialize a new account.
     * @param accountNumber The unique account identifier.
     * @param accountHolderName The name of the account holder.
     * @param initialBalance The starting balance of the account.
     */
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        logTransaction("Account Created", initialBalance);
    }

    /**
     * Deposits an amount into the account.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction("DEPOSIT", amount);
            System.out.printf("✅ Deposit successful. New balance: $%.2f%n", balance);
        } else {
            System.out.println("❌ Deposit failed. Amount must be positive.");
        }
    }

    /**
     * Withdraws an amount from the account.
     * @param amount The amount to withdraw.
     * @return true if withdrawal was successful, false otherwise.
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal failed. Amount must be positive.");
            return false;
        }
        if (balance >= amount) {
            balance -= amount;
            logTransaction("WITHDRAW", amount);
            System.out.printf("✅ Withdrawal successful. New balance: $%.2f%n", balance);
            return true;
        } else {
            System.out.printf("❌ Withdrawal failed. Insufficient funds. Current balance: $%.2f%n", balance);
            return false;
        }
    }

    /**
     * Records a transaction with a timestamp.
     * @param type The type of transaction (e.g., DEPOSIT, WITHDRAW, Account Created).
     * @param amount The amount involved in the transaction.
     */
    private void logTransaction(String type, double amount) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logEntry = String.format("[%s] %-10s: $%-10.2f | New Balance: $%.2f",
                                         timestamp, type, amount, balance);
        transactionHistory.add(logEntry);
    }

    /**
     * Displays the current balance and account details.
     */
    public void getAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name:    " + accountHolderName);
        System.out.printf("Current Balance: $%.2f%n", balance);
        System.out.println("-----------------------\n");
    }

    /**
     * Prints the entire transaction history.
     */
    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History for Account " + accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        System.out.println("--------------------------------------------------\n");
    }
    
    // Getters (optional but good practice)
    public double getBalance() {
        return balance;
    }
}
