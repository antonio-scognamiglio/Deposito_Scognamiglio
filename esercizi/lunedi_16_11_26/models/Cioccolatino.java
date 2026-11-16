package lunedi_16_11_26.models;

public class Cioccolatino extends Cioccolato {
    String forma;
    String ripieno;

    public Cioccolatino(String forma, String ripieno, double cacaoPercentage, String chocolateType) {
        super(ChocolateValue.CIOCCOLATINO, cacaoPercentage, chocolateType);
        this.forma = forma;
        this.ripieno = ripieno;
    }

}
