package order.boot.dto;

/**
 * Oggetto Java ottenuto dall'LLM a partire da una descrizione testuale di una persona.
 * Contiene i dati estratti dal testo libero: nome, cognome e età.
 */
public record PersonDto(String name, String surname, Integer age, String job) {

}
