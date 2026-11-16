package es12.models;

public class Manager extends Dipendente {

    public Manager(String nome, String cognome, double stipendioBase) {
        super(nome, cognome, stipendioBase);
    }

    @Override
    public double calcolaStipendio() {
        return stipendioBase + 500;
    }
}
