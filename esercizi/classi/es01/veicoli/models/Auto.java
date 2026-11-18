package classi.es01.veicoli.models;

public class Auto extends Veicolo {
	private int numeroPorte;

	public Auto(String marca, String modello, int numeroPorte) {
		super(marca, modello);
		this.numeroPorte = numeroPorte;
	}

	@Override
	public void muovi() {
		System.out.println(marca + " " + modello + " viaggia su strada con " + numeroPorte + " porte");
	}
}