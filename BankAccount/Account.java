package BankAccount;

public class Account {
    private final static double DEFAULT_INTEREST_RATE = 0.02d;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    public Account() {
        this.id = bankAccountCount ++;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }
    public void deposit(double amount){
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

    public  double getInterestRate(int year) {
        return Account.interestRate * year * this.balance;
    }
}
