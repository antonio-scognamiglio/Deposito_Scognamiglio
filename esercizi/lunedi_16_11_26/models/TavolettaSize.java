package lunedi_16_11_26.models;

public enum TavolettaSize {
    SMALL(4),
    MEDIUM(12),
    LARGE(24);

    private final int pieces;

    TavolettaSize(int pieces) {
        this.pieces = pieces;
    }

    public int getPieces() {
        return pieces;
    }
}
