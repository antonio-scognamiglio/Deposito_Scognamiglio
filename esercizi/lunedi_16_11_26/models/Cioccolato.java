package lunedi_16_11_26.models;

abstract class Cioccolato {
    final ChocolateValue chocolateValue;
    final String chocolateType;
    final double cacaoPercentage;

    public Cioccolato(ChocolateValue chocolateValue, double cacaoPercentage, String chocolateType) {
        this.chocolateValue = chocolateValue;
        this.cacaoPercentage = cacaoPercentage;
        this.chocolateType = chocolateType;
    }

    // void produce() {
    // System.out.println("Producing " + chocolateValue + " with " + cacaoPercentage
    // + "% cacao.");
    // }
}
