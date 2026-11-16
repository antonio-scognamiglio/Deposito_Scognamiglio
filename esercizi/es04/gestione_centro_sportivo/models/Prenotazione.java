package es04.gestione_centro_sportivo.models;

public abstract class Prenotazione {
    private String idPrenotazione;
    private String nomeCliente;
    private Integer durateOre;
    private Double tariffaOrariaBase;

    public Prenotazione(String idPrenotazione, String nomeCliente, Integer durateOre, Double tariffaOrariaBase) {
        this.idPrenotazione = idPrenotazione;
        this.nomeCliente = nomeCliente;
        this.tariffaOrariaBase = tariffaOrariaBase;
        setDurateOre(durateOre);
    }

    public String getIdPrenotazione() {
        return idPrenotazione;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Integer getDurateOre() {
        return durateOre;
    }

    public Double getTariffaOrariaBase() {
        return tariffaOrariaBase;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setDurateOre(Integer durateOre) {
        if (durateOre <= 1) {
            System.out.println("La durata non può essere inferiore ad un'ora, verrà impostato il valore di default: 1");
            this.durateOre = 1;
        } else {
            this.durateOre = durateOre;
        }
    }

    // Metodo astratto che deve implementare la classe che eredità questa super
    // classe
    public abstract Double calcolaCostoTotale();

    // Metodo concreto
    public String ottieniRiepilogo() {
        return "IdPrenotazione: " + getIdPrenotazione() + "\n" + "Nome Cliente: " + getNomeCliente() + "\n" + "Durata: "
                + getDurateOre() + " ore";
    }

}
