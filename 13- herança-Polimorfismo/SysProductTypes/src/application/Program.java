package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> products = new ArrayList<>();
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("Product #" + i + "data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char selection = sc.next().charAt(0);
            sc.nextLine();

            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Price: ");
            double price = sc.nextDouble();

            if (selection == 'i') {
                System.out.print("Customs fee: ");
                Double customsfee = sc.nextDouble();

                products.add(new ImportedProduct(name, price, customsfee));

            } else if (selection == 'c') {

                products.add(new Product(name, price));

            } else if (selection == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());

                products.add(new UsedProduct(name, price, manufactureDate));

            }
        }
        System.out.println();
        System.out.println("PRICE TAG ");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }

        sc.close();

    }
}
