package entities;

public class ImportedProduct extends Product {
    protected Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
    public final Double totalPrice(double customsFee){
        return getPrice() + customsFee;

    }

    @Override
    public final String priceTag() {
        return getName()
                + " $ "
                + totalPrice(customsFee)
                + " (Customs fee: "
                + customsFee
                + " )";

    }


}
