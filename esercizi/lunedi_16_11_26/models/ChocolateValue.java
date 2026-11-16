package lunedi_16_11_26.models;

public enum ChocolateValue {
    CIOCCOLATINO(2),
    TAVOLETTA(5),
    CIOCCOLATO_CALDO(3);

    private final int costoProduzione;

    ChocolateValue(int costoProduzione) {
        this.costoProduzione = costoProduzione;
    }

    public int getCostoProduzione() {
        return costoProduzione;
    }
}