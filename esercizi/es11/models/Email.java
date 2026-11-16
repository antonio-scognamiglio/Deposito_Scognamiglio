package es11.models;

public class Email implements Notificabile {
    private final String destinatario;

    public Email(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public void inviaNotifica(String messaggio) {
        System.out.println("Email a " + destinatario + ": " + messaggio);
    }
}
