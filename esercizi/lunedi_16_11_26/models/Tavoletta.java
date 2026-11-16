package lunedi_16_11_26.models;

public class Tavoletta extends Cioccolato {
    public Tavoletta(double cacaoPercentage, String chocolateType, String additions, double weight) {
        super(ChocolateValue.TAVOLETTA, cacaoPercentage, chocolateType);
        this.weight = weight;
        this.additions = additions;
    }

    // Proprietà aggiuntive come peso e se contiene o meno aggiunte
    private double weight;
    private String additions;
}
