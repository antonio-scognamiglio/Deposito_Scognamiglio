package classi.es01.veicoli.models;

public class Moto extends Veicolo {
	public Moto(String marca, String modello) {
		super(marca, modello);
	}

	@Override
	public void muovi() {
		System.out.println(marca + " " + modello + " sfreccia su due ruote");
	}
}