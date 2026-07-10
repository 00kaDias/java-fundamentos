package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    private String manufactureDate;

    public UsedProduct (Date manufactureDate){
    
    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
         this.manufactureDate = new SimpleDateFormat("dd/MM/yyyy").format(manufactureDate);
    }

    @Override
    public String priceTag() {
        return getName()
                + " (USED) $"
                + getPrice()
                + " (Manufacture date: "
                + manufactureDate
                + ")";

    }

}
