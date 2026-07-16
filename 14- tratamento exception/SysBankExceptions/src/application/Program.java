package application;

import java.util.Locale;
import java.util.Scanner;

import model.DomainExceptions.DomainExceptions;
import model.entities.Account;

public class Program {
public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    try {
        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdraw = sc.nextDouble();
System.out.println();
        Account account = new Account(number, holder, balance, withdraw);

        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);

        System.out.println(account);




        
    } 
    catch (DomainExceptions e) {
        System.out.println("Withdraw error: " +e.getMessage());
    }
sc.close();
}
}
