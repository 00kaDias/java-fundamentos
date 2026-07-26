package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter contract data: ");
        System.out.print("Number: ");

        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Total value: ");
        double totalValue = sc.nextDouble();
        System.out.print("Installments: ");
        int amount = sc.nextInt();
        Contract contract = new Contract(number, date, totalValue);

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, amount);
        for (Installment i : contract.getInstallments()) {
            System.out.println(i);
        }
        sc.close();

    }
}
