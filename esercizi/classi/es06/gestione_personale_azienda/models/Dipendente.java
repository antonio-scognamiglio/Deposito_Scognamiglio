package classi.es06.gestione_personale_azienda.models;

public abstract class Dipendente {
    private String nome;
    private String id;
    private double stipendioBase;

    public Dipendente(String nome, String id, double stipendioBase) {
        this.nome = nome;
        this.id = id;
        setStipendioBase(stipendioBase);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getStipendioBase() {
        return stipendioBase;
    }

    public void setStipendioBase(double stipendioBase) {
        if (stipendioBase < 0) {
            throw new IllegalArgumentException("Lo stipendio base non può essere negativo.");
        }
        this.stipendioBase = stipendioBase;
    }

    public abstract double calcolaStipendio();
}
