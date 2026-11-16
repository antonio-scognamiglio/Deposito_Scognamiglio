package es11.models;

public class SMS implements Notificabile {
    private final String numero;

    public SMS(String numero) {
        this.numero = numero;
    }

    @Override
    public void inviaNotifica(String messaggio) {
        System.out.println("SMS al " + numero + ": " + messaggio);
    }
}
