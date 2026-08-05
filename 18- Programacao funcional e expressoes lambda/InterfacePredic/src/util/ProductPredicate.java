package util;

import entities.Product;
import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {

    @Override
    public boolean test(Product t) {
        return t.getPrice() >= 100;
    }
    

}
