package EserciziSingleton.medio;

public class Medio {
    private static void stampaEsitoErogazione(boolean checkErogazione) {
        System.out.println("********\n" + "Esito erogazione: " + (checkErogazione ? "Riuscita" : "Non riuscita"));
    }

    public static void main(String[] args) {
        // Non si fa il new perché il compilatore lo fa per noi
        DistributoreBevande distributoreBevande = DistributoreBevande.INSTANCE;

        distributoreBevande.leggiCreditoDistributore();
        distributoreBevande.inserisci(5);
        distributoreBevande.leggiCreditoDistributore();
        stampaEsitoErogazione(distributoreBevande.eroga(2));
        distributoreBevande.leggiCreditoDistributore();
        stampaEsitoErogazione(distributoreBevande.eroga(4));
        distributoreBevande.leggiCreditoDistributore();
        distributoreBevande.inserisci(-100);
    }
}
