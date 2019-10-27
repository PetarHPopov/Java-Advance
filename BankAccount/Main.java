package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer,Account> accountMap = new HashMap<>();
        String line;
        while (!"End".equals(line = reader.readLine())){
            String [] tokens = line.split("\\s+");
            switch (tokens.length){
                case 1:
                    Account account = new Account();
                    accountMap.put(account.getId(),account);
                    System.out.println(String.format("Account ID%d created",account.getId()));
                    break;
                case 2:
                    double rate = Double.parseDouble(tokens[1]);
                    Account.setInterestRate(rate);
                    break;
                case 3:
                    int id = Integer.parseInt(tokens[1]);
                    if (!accountMap.containsKey(id)){
                        System.out.println("Account does not exist");
                    }else {
                        Account bankAccount = accountMap.get(id);
                        if ("Deposit".equalsIgnoreCase(tokens[0])){
                            double amount = Double.parseDouble(tokens[2]);
                            bankAccount.deposit(amount);
                            System.out.println(String.format("Deposited %.0f to ID%d",amount,id));
                        }else {
                            int years = Integer.parseInt(tokens[2]);
                            System.out.println(String.format("%.2f",bankAccount.getInterestRate(years))) ;
                        }
                    }
                    break;
            }
        }
    }
}
