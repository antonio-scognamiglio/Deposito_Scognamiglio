package lunedi_16_11_26.models;

public class CioccolatoCaldo extends Cioccolato {
    double temperature;
    double density;

    public CioccolatoCaldo(double cacaoPercentage, String chocolateType, double temperature, double density) {
        super(ChocolateValue.CIOCCOLATO_CALDO, cacaoPercentage, chocolateType);
        this.temperature = temperature;
        this.density = density;
    }

}
