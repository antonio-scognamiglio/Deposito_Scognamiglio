public class Fabbrica {
    private int pieceAmount = 100;
    // Ogni giorno può produrre massimo 100 pezzi di cioccolato, io partirei con un
    // contatore da cui sottraggo una quantità
    private int day = 1;

    // Serve un metodo che resetta il numero di pezzi e li reimoposta a 100
    // incrementando il giorno
    public void resetPezzi() {
        pieceAmount = 100;
        day++;
    }

    // un metodo che preso in input la quantità di pezzi da produrre ed il tipo di
    // cioccolato calcola quanto deve scalare e se è possibile scala la quantita
    public void produce(int quantity, ChocolateType type) {
        int neededPieces = quantity * type.getCostoProduzione();
        if (neededPieces <= pieceAmount) {
            pieceAmount -= neededPieces;
            System.out.println("Produzione di " + quantity + " pezzi di cioccolato " + type + " completata.");
        } else {
            System.out.println("Non è possibile produrre " + quantity + " pezzi di cioccolato " + type
                    + ". Pezzi disponibili: " + pieceAmount);
        }
    }

    public void printStatus() {
        System.out.println("Giorno: " + day + ", Pezzi disponibili: " + pieceAmount);
    }
}
