package lunedi_16_11_26.models;

public class Cioccolatino extends Cioccolato {
    String forma;
    String ripieno;

    public Cioccolatino(String forma, String ripieno, ChocolateValue chocolateValue, double cacaoPercentage,
            String chocolateType) {
        super(chocolateValue, cacaoPercentage, chocolateType);
        this.forma = forma;
        this.ripieno = ripieno;
    }

}
