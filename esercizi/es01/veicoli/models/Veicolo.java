package es01.veicoli.models;

public abstract class Veicolo {
	// Marca e Modello sono protected significa che le sottoclassi li usano
	// direttamente mentre dall'esterno non sono accessibili
	protected String marca;
	protected String modello;

	// Questo è il costruttore di Veicolo e viene richiamato con
	// super(marca,modello), parliamo di polimorfismo perché ogni implementazione
	// può avere un metodo diverso per muovi
	public Veicolo(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
	}

	// Metodo concreto: viene ereditato nel senso che è già definito
	public void descrivi() {
		System.out.println("Veicolo: " + marca + " " + modello);
	}

	// Metodo astratto: lo devono implementare le sottoclassi a lora piacimento
	// purché rispettino il contratto la firma della funziona, inoltre deve essere
	// implementato altrimenti dà errore
	public abstract void muovi();
}
