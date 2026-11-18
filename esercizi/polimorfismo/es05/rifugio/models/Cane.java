package polimorfismo.es05.rifugio.models;

public abstract class Cane {
    private String nome;
    private String razza;
    private Integer eta;

    public Cane(String nome, String razza, Integer eta) {
        this.nome = nome;
        this.razza = razza;
        this.eta = eta;
    }

    public final String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public final String getRazza() {
        return razza;
    }

    public final void setRazza(String razza) {
        this.razza = razza;
    }

    public final Integer getEta() {
        return eta;
    }

    public final void setEta(Integer eta) {
        this.eta = eta;
    }

    public String esciDallaGabbia() {
        return String.format("Il cane %s esce dalla gabbia camminando", getNome());
    }

}
