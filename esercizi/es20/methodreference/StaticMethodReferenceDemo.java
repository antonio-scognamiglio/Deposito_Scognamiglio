package es20.methodreference;

@FunctionalInterface
interface MethodReference {
    void helloMethodReference();
}

public class StaticMethodReferenceDemo {

    static void helloMethodReference() {
        System.out.println("From helloMethodReference!");
    }

    public static void main(String[] args) {
        /*
         * Il "::" (method reference) trasforma un metodo in un oggetto assegnabile a
         * una variabile.
         * Un metodo da solo non è un oggetto: senza il "ponte" :: l'assegnazione non è
         * possibile.
         */
        MethodReference methodReference = StaticMethodReferenceDemo::helloMethodReference;
        methodReference.helloMethodReference();
    }
}
