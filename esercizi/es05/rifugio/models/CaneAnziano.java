package es05.rifugio.models;

public class CaneAnziano extends Cane {
    private Boolean bisognoDiRiposo;

    public CaneAnziano(String nome, String razza, Integer eta, Boolean bisognoDiRiposo) {
        super(nome, razza, eta);
        this.bisognoDiRiposo = bisognoDiRiposo;
    }

    @Override
    public String esciDallaGabbia() {
        return getNome() + " esce dalla gabbia molto lentamente e si sdraia al sole";
    }

}
