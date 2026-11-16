package lunedi_16_11_26.models;

public class CioccolatoCaldo extends Cioccolato {
    double temperature;
    double density;

    public CioccolatoCaldo(ChocolateValue chocolateValue, double cacaoPercentage, String chocolateType,
            double temperature, double density) {
        super(chocolateValue, cacaoPercentage, chocolateType);
        this.temperature = temperature;
        this.density = density;
    }

}
