package polimorfismo.es04.gestione_centro_sportivo.models;

public class PrenotazioneCampoCoperto extends Prenotazione {
    private Boolean riscaldamentoAttivo;

    public PrenotazioneCampoCoperto(String idPrenotazione, String nomeCliente, Integer durateOre,
            Double tariffaOrariaBase,
            Boolean riscaldamentoAttivo) {
        super(idPrenotazione, nomeCliente, durateOre, tariffaOrariaBase);
        this.riscaldamentoAttivo = riscaldamentoAttivo;
    }

    @Override
    public Double calcolaCostoTotale() {
        Double costoTotale = getTariffaOrariaBase() * getDurateOre();
        return riscaldamentoAttivo ? costoTotale + 15 : costoTotale;
    }

    @Override
    public String ottieniRiepilogo() {
        return super.ottieniRiepilogo() + "\nRiscaldamento attivo: " + (riscaldamentoAttivo ? "Sì" : "No");
    }

}
