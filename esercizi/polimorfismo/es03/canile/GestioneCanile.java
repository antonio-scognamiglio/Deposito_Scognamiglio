package polimorfismo.es03.canile;

import polimorfismo.es03.canile.models.Cane;
import polimorfismo.es03.canile.models.CaneGabbia;
import polimorfismo.es03.canile.models.CaneLibero;

public class GestioneCanile {
	public static void main(String[] args) {
		// 1. Dichiarare e istanziare un array di tipo Cane[] con una dimensione di
		// almeno 4 elementi.
		Cane[] cani = new Cane[4];
		// Popolare l'array inserendo sia oggetti di tipo CaneGabbia che di tipo
		// CaneLibero
		cani[0] = new CaneGabbia("Fido", 3, 20.0, 10); // Un cane in gabbia
		cani[1] = new CaneLibero("Rex", 5, 30.0, 50.5); // Un cane libero
		cani[2] = new CaneGabbia("Bello", 2, 15.0, 5);
		cani[3] = new CaneLibero("Luna", 4, 12.0, 20.0);

		/*
		 * Eseguire un ciclo (es. un ciclo for-each) sull'array per:
		 * Stampare i dettagli di ogni cane (nome, età, peso).
		 * Invocare i metodi verso() e muoviti() per ciascun cane, dimostrando il
		 * comportamento polimorfico.
		 */
		Double totaleMq = 0.0;
		Integer caniInGabbia = 0;
		for (Cane c : cani) {
			// Stampa dettagli comuni (che esistono in Cane.java)
			System.out.println("Nome: " + c.getNome() + " | Eta: " + c.getEta() + " | Peso: " + c.getPeso());
			// Qui avviene il polimorfismo:
			System.out.println("Verso: " + c.verso());
			System.out.println("Movimento: " + c.muoviti());
			System.out.println("------------------------------------");
			// 3. Calcoli finali
			if (c instanceof CaneLibero) {
				// Dobbiamo "castare" l'oggetto per accedere ai suoi metodi specifici
				CaneLibero libero = (CaneLibero) c;
				totaleMq += libero.getSpazioCorsaMq();
			} else if (c instanceof CaneGabbia) {
				caniInGabbia++;
			}
		}
		System.out.println("Il numero totale dei cani in gabbia è:" + caniInGabbia);
		System.out.println("Il numero totale dei metri quadri percorsi dai cani liberi:" + totaleMq);
	}
}
