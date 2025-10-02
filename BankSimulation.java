public class BankSimulation {
    public static void main(String[] args) {
        // 1. Create a new Account
        System.out.println("--- Starting Bank Account Simulation ---");
        Account myAccount = new Account("1234567890", "Alice Smith", 500.00);
        myAccount.getAccountDetails();

        // 2. Perform a Deposit
        System.out.println("--- Scenario 1: Deposit $250.75 ---");
        myAccount.deposit(250.75);

        // 3. Perform a successful Withdrawal
        System.out.println("\n--- Scenario 2: Withdraw $100.00 ---");
        myAccount.withdraw(100.00);

        // 4. Attempt an unsuccessful Withdrawal (Insufficient Funds)
        System.out.println("\n--- Scenario 3: Attempt to withdraw $1000.00 (Failure) ---");
        myAccount.withdraw(1000.00);

        // 5. Attempt invalid transactions
        System.out.println("\n--- Scenario 4: Attempt invalid transactions ---");
        myAccount.deposit(-50.00);
        myAccount.withdraw(0.00);

        // 6. Display final details and transaction history
        myAccount.getAccountDetails();
        myAccount.printTransactionHistory();
        
        System.out.println("--- Simulation Complete ---");
    }
}
