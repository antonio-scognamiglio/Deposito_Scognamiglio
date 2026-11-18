package polimorfismo.es11;

import polimorfismo.es11.models.Email;
import polimorfismo.es11.models.Notificabile;
import polimorfismo.es11.models.SMS;

public class Main {
    static void main(String[] args) {
        Notificabile email = new Email("tony@example.com");
        email.inviaNotifica("Promozione del 20%");

        Notificabile sms = new SMS("+39 333 1234567");
        sms.inviaNotifica("Codice di verifica: 8472");
    }
}
