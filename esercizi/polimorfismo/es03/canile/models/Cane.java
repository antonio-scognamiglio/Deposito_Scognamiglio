package polimorfismo.es03.canile.models;

public abstract class Cane {
	private String nome;
	private Integer eta;
	private Double peso;

	// Creazione costruttore
	public Cane(String nome, Integer eta, Double peso) {
		this.nome = nome;
		// Validazione semplice
		if (eta != null && eta >= 0) {
			this.eta = eta;
		}
		if (peso != null && peso >= 0) {
			this.peso = peso;
		}
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public Integer getEta() {
		return eta;
	}

	public Double getPeso() {
		return peso;
	}

	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEta(Integer eta) {
		if (eta != null && eta >= 0) {
			this.eta = eta;
		} else {
			System.out.println("Errore: L'età non può essere negativa.");
		}
	}

	public void setPeso(Double peso) {
		if (peso != null && peso >= 0) {
			this.peso = peso;
		} else {
			System.out.println("Errore: Il peso non può essere negativa.");

		}
	}

	// creazione metodi
	public String verso() {
		return "Il cane " + getNome() + " abbaia";
	}

	public String muoviti() {
		return "Il cane " + getNome() + " cammina nel canile";
	}
}
