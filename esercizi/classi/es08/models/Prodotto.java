package classi.es08.models;

import java.math.BigDecimal;

public class Prodotto {
    private String nome;
    private BigDecimal prezzo;

    public Prodotto(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        if (prezzo.compareTo(BigDecimal.ZERO) > 0 && prezzo != null) {
            this.prezzo = prezzo;
        } else {
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero");
        }
    }

    public String getNome() {
        return this.nome;
    }

}
