package applicazioni.lambda;

public class HelloWithLambda {

    public static void main(String[] args) {
        // La lambda è l'equivalente di un'istanza di una classe anonima:
        // new HelloInterface1() { public void displayHello() {
        // System.out.println("Hello"); } }
        HelloInterface1 helloInterface1 = () -> System.out.println("Hello");
        helloInterface1.displayHello();
    }
}
