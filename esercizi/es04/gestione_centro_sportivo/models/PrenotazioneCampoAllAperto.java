package es04.gestione_centro_sportivo.models;

public class PrenotazioneCampoAllAperto extends Prenotazione {
    private Boolean richiedeNoleggioCasacche;

    public PrenotazioneCampoAllAperto(String idPrenotazione, String nomeCliente, Integer durateOre,
            Double tariffaOrariaBase, Boolean richiedeNoleggioCasacche) {
        super(idPrenotazione, nomeCliente, durateOre, tariffaOrariaBase);
        this.richiedeNoleggioCasacche = richiedeNoleggioCasacche;
    }

    @Override
    public Double calcolaCostoTotale() {
        Double tempCosto = getDurateOre() * getTariffaOrariaBase();
        if (richiedeNoleggioCasacche) {
            tempCosto = 1.50 * getDurateOre();
        }
        return tempCosto;
    }

    @Override
    public String ottieniRiepilogo() {
        return super.ottieniRiepilogo() + "\nCasacche richieste: " + (richiedeNoleggioCasacche ? "Sì" : "No");
    }

}
