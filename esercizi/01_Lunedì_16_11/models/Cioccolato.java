abstract class Cioccolato {
    String chocolateType;
    double cacaoPercentage;

    public Cioccolato(String chocolateType, double cacaoPercentage) {
        this.chocolateType = chocolateType;
        this.cacaoPercentage = cacaoPercentage;
    }

    void produce() {
        System.out.println("Producing " + chocolateType + " with " + cacaoPercentage + "% cacao.");
    }

}
