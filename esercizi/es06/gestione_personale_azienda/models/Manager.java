package es06.gestione_personale_azienda.models;


import es06.gestione_personale_azienda.Promuovibile;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Dipendente implements Promuovibile {
    private double bonusProgetto;
    private List<String> progetti;

    public Manager(String nome, String id, double stipendioBase, double bonusProgetto) {
        super(nome, id, stipendioBase);
        this.bonusProgetto = bonusProgetto;
        this.progetti = new ArrayList<>();
    }

    public double getBonusProgetto() {
        return bonusProgetto;
    }

    public void setBonusProgetto(double bonusProgetto) {
        this.bonusProgetto = bonusProgetto;
    }

    public List<String> getProgetti() {
        return progetti;
    }

    public void setProgetti(List<String> progetti) {
        this.progetti = progetti;
    }

    @Override
    public double calcolaStipendio() {
        return getStipendioBase() + bonusProgetto;
    }

    public void assegnaProgetto(String nomeProgetto) {
        progetti.add(nomeProgetto);
        System.out.println("Progetto assegnato: " + nomeProgetto);
    }

    public void assegnaProgetto(String nomeProgetto, String priorita) {
        progetti.add(nomeProgetto + " (Priorità: " + priorita + ")");
        System.out.println("Progetto assegnato: " + nomeProgetto + " con priorità " + priorita);
    }

    @Override
    public void riceviPromozione() {
        System.out.println("Il manager " + getNome() + " ha ricevuto una promozione!");
    }
}
