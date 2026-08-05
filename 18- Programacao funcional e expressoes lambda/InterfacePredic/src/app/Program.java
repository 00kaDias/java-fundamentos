package app;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();
        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 50.00));
        list.add(new Product("Tijolo", 02.00));

        
        
        list.removeIf(p -> p.getPrice() >= 100);
        for (Product p : list) {
            System.out.println(p);

        }
    }
}
