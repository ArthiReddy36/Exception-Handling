import java.sql.*;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(int amount) throws SQLException {
        if (amount <= 0) {
            throw new SQLException("Deposit amount must be greater than 0");
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(int amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void transfer(BankAccount toAccount, int amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Transfer amount must be greater than 0");
            }
            if (this.balance < amount) {
                throw new IllegalArgumentException("Insufficient funds for transfer");
            }
            this.balance -= amount;
            toAccount.balance += amount;
            System.out.println("Transfer successful. Your new balance: " + this.balance);
            System.out.println("Recipient's new balance: " + toAccount.balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(500);

        
        try {
            account1.deposit(200);  
            account1.deposit(-100); 
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        account1.withdraw(150);  
        account1.withdraw(0);    
        account1.withdraw(1000); 

        account1.transfer(account2, 300);  
        account1.transfer(account2, -50);  
        account1.transfer(account2, 1500); 
    }
}
