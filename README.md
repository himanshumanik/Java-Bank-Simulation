# Java Bank Account Simulation

This repository contains a simple Java implementation of a bank account simulation using Object-Oriented Programming (OOP) principles.

## Objective

The goal was to simulate basic bank operations, specifically **deposit** and **withdraw**, while maintaining an **account balance** and a comprehensive **transaction history**.

## Implementation Details

### 1. Account.java (Core Logic)

* **State:** Holds `accountNumber`, `accountHolderName`, `balance`, and a list of `transactionHistory` (as `String` objects).
* **Methods:**
    * `deposit(double amount)`: Increases the balance if the amount is positive and logs the transaction.
    * `withdraw(double amount)`: Decreases the balance if the amount is positive and there are sufficient funds, logging the transaction.
    * `logTransaction(String type, double amount)`: A private helper method to record the transaction details with a timestamp.
    * `getAccountDetails()`: Prints the current account information.
    * `printTransactionHistory()`: Prints all recorded transactions.

### 2. BankSimulation.java (Driver/Test)

* The `main` method demonstrates the functionality by:
    1.  Creating a new account.
    2.  Performing a successful deposit.
    3.  Performing a successful withdrawal.
    4.  Attempting a withdrawal that fails due to insufficient funds.
    5.  Displaying the final account details and the complete transaction history.

## How to Run

1.  Clone the repository: `git clone [YOUR_REPO_LINK]`
2.  Compile the Java files: `javac *.java`
3.  Run the simulation: `java BankSimulation`
