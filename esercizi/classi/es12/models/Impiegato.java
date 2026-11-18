package classi.es12.models;

public class Impiegato extends Dipendente {

    public Impiegato(String nome, String cognome, double stipendioBase) {
        super(nome, cognome, stipendioBase);
    }

    @Override
    public double calcolaStipendio() {
        return stipendioBase;
    }
}
