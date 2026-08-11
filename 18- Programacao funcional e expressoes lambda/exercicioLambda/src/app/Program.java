package app;

import entities.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String path = "C:\\temp\\in.txt";
        File file = new File(path);
        List<Product> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                String[] products = line.split(",");
                list.add(new Product(products[0], Double.valueOf(products[1])));
                line = br.readLine();
            }

        } catch (Exception e) {
            e.getMessage();
        }

        double st1 = list.stream()
        .map(p -> p.getPrice()).reduce(0.0, (x,y) -> x+y) / list.size();
        System.out.println("avg: " + st1);

        list.stream().filter(x -> x.getPrice() < st1)
            .sorted(Comparator.comparing((Product p) -> p.getName()).reversed())
            .forEach(x -> System.out.println(x.getName() + " " + x.getPrice()));
        
        
       

    }
}
