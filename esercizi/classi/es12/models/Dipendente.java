package classi.es12.models;

public abstract class Dipendente {
    protected final String nome;
    protected final String cognome;
    protected final double stipendioBase;

    public Dipendente(String nome, String cognome, double stipendioBase) {
        this.nome = nome;
        this.cognome = cognome;
        this.stipendioBase = stipendioBase;
    }

    public void mostraDati() {
        System.out.println(nome + " " + cognome + " - Stipendio: " + calcolaStipendio());
    }

    public abstract double calcolaStipendio();
}
