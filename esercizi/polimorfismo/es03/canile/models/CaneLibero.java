package polimorfismo.es03.canile.models;

public class CaneLibero extends Cane {
	// Attributo specifico per questa sottoclasse
	private Double spazioCorsaMq;

	/**
	 * Costruttore per CaneLibero
	 * 
	 * @param nome          Nome del cane (passato al padre)
	 * @param eta           Età del cane (passata al padre)
	 * @param peso          Peso del cane (passato al padre)
	 * @param spazioCorsaMq Spazio richiesto (specifico di CaneLibero)
	 */
	public CaneLibero(String nome, Integer eta, Double peso, Double spazioCorsaMq) {
		// SUPER: chiama il costruttore della classe padre (Cane)
		// Invia i dati che il padre sa gestire
		super(nome, eta, peso);

		// Imposta il dato che solo questa classe gestisce
		this.spazioCorsaMq = spazioCorsaMq;
	}

	// Getter per l'attributo specifico
	public Double getSpazioCorsaMq() {
		return spazioCorsaMq;
	}

	/**
	 * Sovrascrive il metodo verso() della classe base.
	 * Usa String.format per inserire il nome del cane dinamicamente.
	 */
	@Override
	public String verso() {
		// %s è un segnaposto per una String (il nome che prendiamo dal getter)
		return String.format("Il cane %s abbaia di gioia!", getNome());
	}

	/**
	 * Sovrascrive il metodo muoviti() della classe base.
	 * Usa String.format per inserire il nome e i metri quadri.
	 */
	@Override
	public String muoviti() {
		// %s per la String (nome)
		// %.1f per il Double (spazioCorsaMq) formattato con 1 decimale
		return String.format("Il cane %s corre felice nel parco percorrendo %.1f mq!",
				getNome(), spazioCorsaMq);
	}
}
