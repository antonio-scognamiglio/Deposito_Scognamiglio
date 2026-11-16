package es03.canile.models;

public class CaneGabbia extends Cane {
	private Integer numeroGabbia;

	public CaneGabbia(String nome, Integer eta, Double peso, Integer numeroGabbia) {
		super(nome, eta, peso);
		this.numeroGabbia = numeroGabbia;
	}

	@Override
	public String muoviti() {
		return "Il cane " + getNome() + " fa avanti e indietro nella gabbia numero " + numeroGabbia;
	}

	public void setNumeroGabbia(Integer numeroGabbia) {

		if (numeroGabbia != null & numeroGabbia >= 0) {
			this.numeroGabbia = numeroGabbia;
		} else {
			System.out.println("Errore: Il numero gabbia non può essere negativo");
		}
	}

}
